package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CateringMapper extends BaseMapper{

    @MapKey("")
    List<Map<String,Object>> selectCater();
}