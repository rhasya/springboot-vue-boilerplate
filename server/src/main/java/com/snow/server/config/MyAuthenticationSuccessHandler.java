package com.snow.server.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (response.isCommitted()) {
            this.logger.debug("response already committed.");
        }
        response.setStatus(HttpServletResponse.SC_OK);
        clearAuthenticationAttributes(request);
    }
}
