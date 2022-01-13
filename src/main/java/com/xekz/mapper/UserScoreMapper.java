package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.UserScore;

public interface UserScoreMapper extends BaseMapper<UserScore,Integer> {

    int insertUserScore(UserScore us);

    int deleteScore(Integer[] ids);
}