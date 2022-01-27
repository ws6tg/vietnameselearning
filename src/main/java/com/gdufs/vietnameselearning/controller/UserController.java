package com.gdufs.vietnameselearning.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.services.RedisService;
import com.gdufs.vietnameselearning.services.UserService;
import com.gdufs.vietnameselearning.utils.FileUtil;
import com.gdufs.vietnameselearning.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/login")
    public @ResponseBody
    ResultJson hh() {
        return new ResultJson(0, "注册失败");
>>>>>>> d21228c (Initial commit)
    }

    @PostMapping("/register")
    public @ResponseBody
    ResultJson register(User user, String phonecode, HttpSession session) {
        if (!phonecode.equalsIgnoreCase(redisService.get(user.getPhone()))) {
            return new ResultJson(0, "短信验证码不正确");
        }
        if (userService.save(user)) {
            User user1 = userService.getOne(new QueryWrapper<User>().eq("phone", user.getPhone()));
            session.removeAttribute("code");
            session.setAttribute("userId", user1.getId());
            return new ResultJson(1, user1);
        }
        return new ResultJson(0, "注册失败");

    }

    @PostMapping("/exit")
    public @ResponseBody
    ResultJson exit(HttpSession session) {
        session.invalidate();
        return new ResultJson(1, "退出成功");

    }

    //    手机号密码登录
    @PostMapping("/login/1")
    public @ResponseBody
    ResultJson loginWithPassword(User user, @RequestParam(value = "checkcode") String checkcode, HttpSession session) {
        if (!checkcode.equalsIgnoreCase((String) session.getAttribute("code"))) {
            return new ResultJson(0, "验证码不正确");
        }
        if (userService.getOne(new QueryWrapper<User>().eq("phone", user.getPhone())) == null) {
            return new ResultJson(0, "手机号码不存在");
        } else {
            User user1 = userService.getOne(new QueryWrapper<User>().eq("phone", user.getPhone()));
            if (!user1.getPassword().equals(user.getPassword())) {
                return new ResultJson(0, "密码错误");
            } else {
                session.removeAttribute("code");
                session.setAttribute("userId", user1.getId());
                return new ResultJson(1, user1);
            }
        }

    }

    //    手机验证码登录
    @PostMapping("/login/2")
    public @ResponseBody
    ResultJson loginWithPhone(@RequestParam String phone, @RequestParam String phonecode, HttpSession session) {
        if (!phonecode.equalsIgnoreCase(redisService.get(phone))) {
            return new ResultJson(0, "短信验证码不正确");
        } else {
            User user = userService.getOne(new QueryWrapper<User>().eq("phone", phone));
            session.removeAttribute("code");
            session.setAttribute("userId", user.getId());
            return new ResultJson(1, user);
        }
    }

    //上传头像
    @PostMapping(value = "/uploadimg")
    public @ResponseBody
    ResultJson uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        String fileName = userId+"_"+file.getOriginalFilename();
        //设置文件上传路径
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\uploadimg\\";
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            User user = userService.getById(userId);
            String oldFile = user.getHead();
            if (oldFile != null && !oldFile.equals("")) {
                String oldFileName = oldFile.substring(11);
                if (!oldFileName.equals(fileName)) FileUtil.deleteFile(filePath + oldFileName);
            }
            user.setHead("/uploadimg/" + fileName);
            userService.saveOrUpdate(user);
            return new ResultJson(1, "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultJson(0, "上传失败");
        }
    }

    //获取头像
    @GetMapping("/getimg")
    public String downloadImg(HttpServletRequest request,Integer userId) {
        if (userId==null)
            userId = (Integer) request.getSession().getAttribute("userId");
        User user = userService.getById(userId);
        System.out.println(user.getHead());
        return user.getHead();
    }

    //上传数据
    @PostMapping(value = "/uploaddata")
    @ResponseBody
    public ResultJson uploadData(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        String filename = file.getOriginalFilename();
        try {
//            上传文件
            String ext = filename.substring(filename.lastIndexOf(".")).toLowerCase();
            //设置文件上传路径
            String filePath = System.getProperty("user.dir") + "\\userdata\\";
            FileUtil.uploadFile(file.getBytes(), filePath, userId + ext);
            return new ResultJson(1, "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultJson(0, "上传失败");
        }
    }

    //    下载数据
    @GetMapping("/getdata")
    public void getData(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(required = false, defaultValue = "inline") String type,
                        @RequestParam(required = false, defaultValue = ".txt") String ext) throws UnsupportedEncodingException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        try {
            // path是指想要下载的文件的路径
            File file = new File(System.getProperty("user.dir") + "\\userdata\\" + userId + ext);
            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", type + ";filename=" + URLEncoder.encode(userId + ext, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            response.setStatus(404);
        }
    }

    //添加密码
    @PostMapping("/addPassword")
    @ResponseBody
    public ResultJson addPassword(HttpServletRequest request, @RequestParam String password) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        User user = userService.getById(userId);
        if (user.getPassword() == null) {
            user.setPassword(password);
            return new ResultJson(1, userService.saveOrUpdate(user));
        }
        return new ResultJson(0, "密码已存在");

    }


//    更改密码
    @PostMapping("/updatePassword")
    @ResponseBody
    public ResultJson updatePassword(HttpServletRequest request, @RequestParam String oldpassword,
                                     @RequestParam String newpassword) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        User user = userService.getById(userId);
        if (oldpassword.equals(user.getPassword())) {
            user.setPassword(newpassword);
            return new ResultJson(1, "修改成功");
        } else {
            return new ResultJson(0, "修改失败");
        }

    }


//    忘记密码
    @PostMapping("/forgetPassword")
    @ResponseBody
    public ResultJson forgetPassword(HttpServletRequest request, @RequestParam String password,
                                     @RequestParam String phonecode) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        User user = userService.getById(userId);
        if (!phonecode.equalsIgnoreCase(redisService.get(user.getPhone()))) {
            return new ResultJson(0, "手机验证码错误");
        }
        user.setPassword(password);
        return new ResultJson(1, "修改成功");
    }




}
