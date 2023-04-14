package com.ouka.interceptor;

import com.ouka.model.User;
import com.ouka.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private String contextPath;
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null && userService.getUserByUsername(user.getUsername()) != null) {
            System.out.println(true);
            return true;
        } else {
            response.sendRedirect(contextPath + "/login");
            System.out.println(false);
            return false;
        }
    }
}
