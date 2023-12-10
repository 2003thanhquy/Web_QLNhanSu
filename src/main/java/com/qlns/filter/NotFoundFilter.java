package com.qlns.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;


public class NotFoundFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestPath = request.getServletPath();
        if (!isValidPath(requestPath)){
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }else {
            filterChain.doFilter(request,response);
        }

    }
    private boolean isValidPath(String path) {
        //        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
//        for (Map.Entry<String, ? extends ServletRegistration> entry : servletRegistrations.entrySet()) {
//            String servletName = entry.getKey();
//            ServletRegistration servletRegistration = entry.getValue();
//            Collection<String> urlPatterns = servletRegistration.getMappings();
//            for (String urlPattern : urlPatterns) {
//                System.out.println(urlPattern);
//               if(urlPattern.equals(requestPath)){
//                   filterChain.doFilter(request,response);
//                   return;
//               }
//            }
//        }



        return true;
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
