package com.xekz.controller;

import com.xekz.base.BaseController;
import com.xekz.service.CaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cater")
public class CaterController extends BaseController {
    @Autowired
    private CaterService caterService;


    @RequestMapping("findCaterings")
    @ResponseBody
    public List<Map<String,Object>> sayCaters(){
        return caterService.findCater();
    }

}
