package com.eugene.common.filter;

import com.eugene.common.utils.ContextUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Nothing to do
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ContextUtil.getHttpServletRequest();
        HttpServletResponse httpServletResponse = ContextUtil.getHttpServletResponse();
        Boolean isFilter = true;
        if (httpServletRequest.getRequestURI().equals("/user/login")) {
            isFilter = false;
        }

        if (isFilter && getJwtToken(httpServletRequest) == null) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无token");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Nothing to do
    }

    private String getJwtToken(HttpServletRequest request) {
        return request.getHeader(ContextUtil.JWT_TOKEN);
    }

}
