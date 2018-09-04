/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.jwtgenerator.dto;

import java.util.Date;

/**
 * runt.com.co
 *
 * @author rchicangana
 */
public class TokenJwtDTO {

    private String issuer;
    private String subject;
    private String audience;
    private Long expiration;
    private Date notBefore;
    private Date issuedAt;
    private String id;
    private String ip;
    private String username;
    private String password;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(final String issuer) {
        this.issuer = issuer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(final String audience) {
        this.audience = audience;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(final Long expiration) {
        this.expiration = expiration;
    }

    public Date getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(final Date notBefore) {
        this.notBefore = notBefore;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(final Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
    
    
    

}
