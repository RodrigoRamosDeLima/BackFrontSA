package com.senai.liquidsa.controllers;

import com.senai.liquidsa.repositories.UsuarioRepository;
import com.senai.liquidsa.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
@Component
public class InterceptorController implements HandlerInterceptor {

    private final LoginUtil loginUtil;
    private final UsuarioRepository usuarioRepository;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        boolean isValid = loginUtil.isTokenValid(token);

        if (isValid) {
            request.setAttribute("loggedUser", usuarioRepository.findByLogin(loginUtil.extractLogin(token)).orElse(null));
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        HandlerInterceptor.super.preHandle(request, response, handler);

        return true;
    }
}
