package com.ruoyi.project.globalapp.main.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.global.userAuths.domain.UserInfoGet;
import com.ruoyi.project.globalapp.main.domain.PhoneInfo;
import com.ruoyi.project.globalapp.main.domain.UserLogin;
import com.ruoyi.project.globalapp.main.service.IUserLoginService;
import com.ruoyi.project.tool.redis.RedisTool;
import com.ruoyi.project.tool.sms.AliSmsTool;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户注册和登陆模块
 */
@Controller
@RequestMapping("/v1/user")
@Api(tags = "用户第三方进行登陆以及手机号码进行绑定", description = "UserAuthsController")
public class UserLoginController extends BaseController {
    @Autowired
    private IUserLoginService userLoginService;

    /**
     * 第三方进行登陆
     */
    @PostMapping("/addUserInfo")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "第三方绑定", httpMethod = "POST", response = UserInfoGet.class)
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult saveUserInfo(UserLogin userLogin) {
        UserInfoGet userInfoGet = userLoginService.addUserInfo(userLogin);
        if (userInfoGet != null) {
            return success("操作成功", 200, userInfoGet);
        }
        return error(500, "服务忙请稍后重试");
    }


    /**
     * 微信授权获取openid
     */
    @PostMapping("/findWxInfo")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "获取微信的基本信息", httpMethod = "POST")
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult findWxInfo(String code) {
        if (ObjectUtil.isNotNull(code)) {
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("appid", "wx42e36e2a036dc4ca");
            paramMap.put("secret", "71c77d7bc3d6eb7fe01a0a331f0e1171");
            paramMap.put("js_code", code);
            paramMap.put("grant_type", "authorization_code");
            String rep = HttpUtil.post("https://api.weixin.qq.com/sns/jscode2session", paramMap);
            StaticLog.info("rep:{}", rep);
            JSONObject object = JSONObject.parseObject(rep);
            return success("操作成功", 200, object);
        }
        return error(500, "CODE获取失败");
    }

    /**
     * 绑定手机号码
     */
    @PostMapping("/addUserPhoneNo")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "手机号码绑定", httpMethod = "POST")
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addUserPhoneNo(PhoneInfo phoneInfo) {
        // 验证当前验证码是否正确或过期
        String redis_code = RedisTool.verifyCode(phoneInfo.getPhoneNo());
        if (redis_code != null) {
            if (redis_code.equals(phoneInfo.getCode())) {
                // 进行手机号码绑定
                boolean bound = userLoginService.boundPhone(phoneInfo.getPhoneNo(), phoneInfo.getPhoneCode(), phoneInfo.getUserNo());
                if (bound) {
                    return success(200, "绑定成功");
                } else {
                    return success(500, "绑定失败");
                }
            } else {
                return error(500, "验证码错误");
            }
        } else {
            return error(500, "验证码过期");
        }
    }


    /**
     * 获取验证码
     */
    @PostMapping("/findCode")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "失败"),
    })
    @ApiOperation(value = "手机号码获取验证码", httpMethod = "POST")
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult findCode(String phoneNo, String phoneCode) throws Exception {
        // 生成验证码进行redis 验证码存储（5分钟进行超时）
        String code = AliSmsTool.sendMsg(phoneNo, phoneCode);
        if (code != null) {
            return success("验证码获取成功", 200, code);
        }
        return error(500, "验证码获取失败");
    }
}
