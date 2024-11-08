package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class filterdemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String[]urls={"/login.jsp","/imgs/","/css/","/loginServlet","register.jsp","registerServlet"};
        String url=request.getRequestURI().toString();
        for(String s:urls){
            if(url.contains(s)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
           filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            request.setAttribute("login_msg","你尚未登录");
            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
