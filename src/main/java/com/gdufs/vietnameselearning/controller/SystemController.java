package com.gdufs.vietnameselearning.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.services.RedisService;
import com.gdufs.vietnameselearning.services.UserService;
import com.gdufs.vietnameselearning.utils.CpachaUtil;
import com.gdufs.vietnameselearning.utils.PhoneCodeUtil;
import com.gdufs.vietnameselearning.utils.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@Slf4j
public class SystemController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

//    根据验证码长度，宽度，高度生成验证码，并传入session
    @GetMapping("/checkCode")
    public void generateCpacha(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
                               @RequestParam(value="w",defaultValue="110",required=false) Integer w,
                               @RequestParam(value="h",defaultValue="39",required=false) Integer h){
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        String generatorVCode = cpachaUtil.generatorVCode();
        log.info(generatorVCode);
        request.getSession().setAttribute("code", generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "png", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    发送注册手机验证码
    @PostMapping("/phoneCode/1")
    @ResponseBody
    public Object getRigisterCode(HttpServletRequest request,
                                 @RequestParam String checkcode,
                                 @RequestParam String phone,
                                 HttpSession session) throws Exception {
//        静态验证码不正确
        if(!checkcode.equalsIgnoreCase((String) session.getAttribute("code"))){
            return new ResultJson(0,"验证码不正确");
        }
//        手机号已被注册
        if(userService.getOne(new QueryWrapper<User>().eq("phone",phone))!=null){
            return new ResultJson(0,"手机号已被注册");
        }

        String code=PhoneCodeUtil.genCode();
        redisService.set(phone, code);
        redisService.expire(phone, 300);
        return PhoneCodeUtil.sendCode(phone,code);

    }

    //    发送登录手机验证码
    @PostMapping("/phoneCode/2")
    @ResponseBody
    public Object getLoginCode(HttpServletRequest request,
                                  @RequestParam String checkcode,
                                  @RequestParam String phone,
                                  HttpSession session) throws Exception {
//        静态验证码不正确
        if(!checkcode.equalsIgnoreCase((String) session.getAttribute("code"))){
            return new ResultJson(0,"验证码不正确");
        }
//        手机号已被注册
        if(userService.getOne(new QueryWrapper<User>().eq("phone",phone))==null){
            return new ResultJson(0,"手机号码不存在");
        }

        String code=PhoneCodeUtil.genCode();
        redisService.set(phone, code);
        redisService.expire(phone, 300);
        return PhoneCodeUtil.sendCode(phone,code);

    }



}
