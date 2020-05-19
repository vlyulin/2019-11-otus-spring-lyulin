package ru.otus.spring.oca.security.jwt;

import org.springframework.stereotype.Component;

@Component
public class OracleTokenProvider {

    private String oracleJwtToken;

    public void setOracleJwtToken(String oracleJwtToken) {
        this.oracleJwtToken = oracleJwtToken;
    }

    public String getOracleJwtToken() {
        return oracleJwtToken;
    }
}
