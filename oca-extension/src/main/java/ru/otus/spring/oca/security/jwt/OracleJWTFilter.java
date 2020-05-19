package ru.otus.spring.oca.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import ru.otus.spring.oca.security.jwt.OracleTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * Перехватить Oracle JWT
 */
public class OracleJWTFilter extends GenericFilterBean {

    public static final String ORACLE_AUTHORIZATION_HEADER = "OracleToken";
    private OracleTokenProvider oracleTokenProvider;

    public OracleJWTFilter(OracleTokenProvider oracleTokenProvider) {
        this.oracleTokenProvider = oracleTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // TODO: Проверить, что уже авторизованы
        // SecurityContextHolder.getContext().getAuthentication();
        String oracleJwt = resolveOracleToken(httpServletRequest);
        System.out.println("XXX Oracle jwt: " + oracleJwt);
        oracleTokenProvider.setOracleJwtToken(oracleJwt);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String resolveOracleToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(ORACLE_AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            // return bearerToken.substring(7); // Нет смысла вырезать, потом добавлять
            return  bearerToken;
        }
        return null;
    }
}
