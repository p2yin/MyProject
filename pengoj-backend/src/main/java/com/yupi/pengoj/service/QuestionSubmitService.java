package com.yupi.pengoj.service;

import com.yupi.pengoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.pengoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.pengoj.model.entity.User;

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

}
