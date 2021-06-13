package kr.ac.jejunu.jejuteamate.config.security.jwt;

public class JwtProperties {
    String secretKey = "portal";
    long tokenValidTime = 60 * 60 * 1000L;
    String tokenPrefix = "Bearer";
    String headerString = "token";
}
