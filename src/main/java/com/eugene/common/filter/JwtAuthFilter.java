package com.eugene.common.filter;

import com.eugene.common.utils.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        Boolean isFilter = !request.getRequestURI().equals("/user/login");

        if (isFilter) {

            if (getJwtToken(request) == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无token");
                return;
            }

            String authToken = request.getHeader("jwt-token");
            logger.info(authToken);
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
