package com.linkiospace.payload.request;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 40)
    private String password;

    @NotNull
    private String phoneNumber;

    private String profilePicture;

    @NotNull
    private String jobTitle;

    @NotNull
    private String companyName;

    private String websitePortfolioLink;

    private Set<String> role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
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

    public String getWebsitePortfolioLink() {
        return websitePortfolioLink;
    }

    public void setWebsitePortfolioLink(String websitePortfolioLink) {
        this.websitePortfolioLink = websitePortfolioLink;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}