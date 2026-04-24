package com.university.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) {

        String uri = request.getRequestURI();

        // Login logging
        if (uri.contains("/login")) {
            System.out.println("Login attempt: " + request.getParameter("email") + " at " + new java.util.Date());
        }

        // Registration logging
        if (uri.contains("/register")) {
            System.out.println("Course registration attempt: " + uri);
        }

        return true; // continue request
    }
}