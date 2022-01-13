package com.xekz.service;

import com.xekz.base.BaseService;
import com.xekz.bean.Catering;
import com.xekz.mapper.CateringMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CaterService extends BaseService<Catering,Integer> {

    @Resource
    private CateringMapper cateringMapper;


    /**
     * 查询所有菜单信息
     * @return
     */
    public List<Map<String,Object>> findCater(){
        return cateringMapper.selectCater();
    }


}



