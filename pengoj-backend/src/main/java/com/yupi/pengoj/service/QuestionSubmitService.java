package com.yupi.pengoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.pengoj.model.dto.question.QuestionQueryRequest;
import com.yupi.pengoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.pengoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.pengoj.model.entity.Question;
import com.yupi.pengoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.pengoj.model.entity.User;
import com.yupi.pengoj.model.vo.QuestionSubmitVO;
import com.yupi.pengoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author melvyn
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-06-02 16:50:22
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest   题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    /**
     * 获取查询条件
     *
     * @param questionsubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionsubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}


