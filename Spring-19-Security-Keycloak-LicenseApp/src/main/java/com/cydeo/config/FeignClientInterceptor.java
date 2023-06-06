package com.cydeo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer ";

    /**
     * Whenever FiegnClient is called, this method stops everything and
     * executes its lines of code.
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {

        //getting the authentication, all is saved in the SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SimpleKeycloakAccount details = (SimpleKeycloakAccount) authentication.getDetails();
        //passing the token information to the header
        requestTemplate.header(AUTHORIZATION_HEADER, TOKEN_TYPE + details.getKeycloakSecurityContext().getTokenString());
    }
}