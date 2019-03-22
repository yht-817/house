package com.ruoyi.project.globalapp.main.controller;


import cn.hutool.http.HttpUtil;
import com.ruoyi.project.tool.ftp.FtpClientTool;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/v1/ftp")
@Api(tags = "文件上传接口", description = "FtpApi")
public class FtpApi {

    @PostMapping("/fileupload")
    @ResponseBody
    public Object fileUpload(@RequestParam("img") MultipartFile img) {
        Map<String, Object> msg = new HashMap<>();
        //上传的目录
        String dir = "arike";
        String imgPath = FtpClientTool.uploadSingle(img, dir);
        if (imgPath != null) {
            msg.put("code", 200);
            msg.put("url", imgPath);
            return msg;
        }
        msg.put("code", 500);
        msg.put("url", null);
        return msg;
    }


//    public static void main(String[] args) {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("key", "ZJVBZ-6ARL6-5BCSC-MDP4T-V3BFJ-DYFIP");
//        paramMap.put("address", "温哥华");
//        paramMap.put("oversea", "1");
//        String s = HttpUtil.get("https://apis.map.qq.com/ws/geocoder/v1", paramMap);
//        System.out.println(s);
//    }

}
