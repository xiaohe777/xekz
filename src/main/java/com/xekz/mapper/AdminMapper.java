package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Mapper
public interface AdminMapper extends BaseMapper<Admin,Integer> {


     Admin selectUserByName(String userName);
}