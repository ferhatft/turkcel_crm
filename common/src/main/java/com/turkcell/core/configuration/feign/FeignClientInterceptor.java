package com.turkcell.core.configuration.feign;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            String jwtToken = attributes.getRequest().getHeader(AUTHORIZATION_HEADER);
            if (jwtToken != null && jwtToken.startsWith("Bearer")) {
                jwtToken = jwtToken.substring(7);
                requestTemplate.header(AUTHORIZATION_HEADER, "Bearer " + jwtToken);
            }
        }
    }
}
