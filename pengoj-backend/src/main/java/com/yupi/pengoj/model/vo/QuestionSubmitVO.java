package com.yupi.pengoj.model.vo;

import cn.hutool.json.JSONUtil;
import com.yupi.pengoj.model.dto.question.JudgeConfig;
import com.yupi.pengoj.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 题目封装类
 * @TableName question
 */

@Data
public class QuestionVO implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(QuestionVO.class);

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;

    /**
     * 判题配置(json对象)
     */
    private JudgeConfig judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建题目人的信息
     */
    private UserVO userVO;

    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (tagList != null) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if (voJudgeConfig != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    //备用方案
//    public static QuestionVO objToVo(Question question) {
//        if (question == null) {
//            return null;
//        }
//        QuestionVO questionVO = new QuestionVO();
//        BeanUtils.copyProperties(question, questionVO);
//
//        // JSON fields
//        String tags = question.getTags();
//        String judgeConfigStr = question.getJudgeConfig();
//
//        // Add logging and validity checks for JSON fields
//        try {
//            if (JSONUtil.isJsonArray(tags)) {
//                questionVO.tags = JSONUtil.toList(JSONUtil.parseArray(tags), String.class);
//            } else {
//                logger.error("Invalid JSON format for tags: {}", tags);
//            }
//
//            if (JSONUtil.isJsonObj(judgeConfigStr)) {
//                questionVO.judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
//            } else {
//                logger.error("Invalid JSON format for judgeConfig: {}", judgeConfigStr);
//            }
//        } catch (Exception e) {
//            logger.error("Error parsing JSON fields: ", e);
//            throw new RuntimeException("Error parsing JSON fields", e);
//        }
//
//        return questionVO;
//    }

    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tagList = JSONUtil.toList(question.getTags(), String.class);
        questionVO.setTags(tagList);
        String judgeConfigStr = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfigStr, JudgeConfig.class));
        return questionVO;
    }

    private static final long serialVersionUID = 1L;
}