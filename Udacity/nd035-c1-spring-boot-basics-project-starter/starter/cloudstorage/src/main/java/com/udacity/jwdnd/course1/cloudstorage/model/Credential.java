package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {

    private Integer credentialid;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userid;

    public Credential() {
    }

    public Credential(Integer credentialId, String url, String username, String key, String password, Integer userId) {
        this.credentialid = credentialId;
        this.url = url;
        this.username = username;
        this.key = key;
        this.password = password;
        this.userid = userId;
    }

    public Integer getCredentialId() {
        return credentialid;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialid = credentialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userid;
    }

    public void setUserId(Integer userId) {
        this.userid = userId;
    }
}