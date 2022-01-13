package com.xekz.service;

import com.xekz.base.BaseService;
import com.xekz.bean.UserScore;
import com.xekz.mapper.UserScoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserScoreService extends BaseService<UserScore,Integer> {

    @Resource
    private UserScoreMapper userScoreMapper;

    int insertUserScore(UserScore us){
        return userScoreMapper.insertUserScore(us);
    }
}
