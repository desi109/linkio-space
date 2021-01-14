export default function authHeader() {
  let user = JSON.parse(localStorage.getItem('user'));

  if (user && user.accessToken) {
    return { Authorization: 'Bearer ' + user.accessToken };  // Spring Boot back-end authorization
  } else {
    return {};
  }
}
