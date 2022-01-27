package com.gdufs.vietnameselearning.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if(userId != null){
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}
