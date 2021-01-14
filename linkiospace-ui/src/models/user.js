export default class User {
  constructor(userCode, firstName, lastName, email, password, phoneNumber, jobTitle, companyName, bio, websitePortfolioLink) {
    this.userCode = userCode;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.jobTitle = jobTitle;
    this.companyName = companyName;
    this.bio = bio;
    this.websitePortfolioLink = websitePortfolioLink;
  }
}

