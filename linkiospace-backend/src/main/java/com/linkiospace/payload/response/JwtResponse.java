package com.linkiospace.payload.response;

import java.util.List;

public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String userCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private String companyName;
    private String bio;
    private String websitePortfolioLink;
    private List<Long> connections;
    private List<String> roles;


    public JwtResponse(String accessToken, Long id, String userCode, String firstName, String lastName, String email,
                       String phoneNumber, String jobTitle, String companyName, String bio, String websitePortfolioLink,
                       List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.bio = bio;
        this.websitePortfolioLink = websitePortfolioLink;
        this.roles = roles;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Long> getConnections() {
        return connections;
    }

    public void setConnections(List<Long> connections) {
        this.connections = connections;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}