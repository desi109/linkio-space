import axios from 'axios';
//import { param } from 'jquery';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/v1/';

class UserService {

  // for User Connections Board
  getUserConnections() {
    return axios.get(`${API_URL}user/connections`, { headers: authHeader() });
  }

  getUserInfoByUserCode(userCode) {
    return axios.get(`${API_URL}user/details/${userCode}`, { headers: authHeader() });
  }

  deleteUserConnection(id) {
    return axios.delete(`${API_URL}user/connections/${id}`, { headers: authHeader() });
  }

  deleteAllUserConnections(id) {
    return axios.delete(`${API_URL}user/connections/all/${id}`, { headers: authHeader() });
  }


  // for User Search Board
  getUserSearch() {
    return axios.get(`${API_URL}user/search`, { headers: authHeader() });
  }

  findUserByUserCode(userCode) {
    return axios.get(`${API_URL}user/search/${userCode}`, { headers: authHeader() });
  }

  addUserAsConnection(userCode) {
    return axios.post(`${API_URL}user/search/${userCode}`, { body: userCode }, { headers: authHeader() });
  }


  // for Profile
  getUserProfileInfo(id) {
    return axios.get(`${API_URL}profile/${id}`, { headers: authHeader() });
  }

  updateUserInformation(id, data) {
    return axios.put(`${API_URL}profile/${id}`, data, { headers: authHeader() });
  }

  
  // for Admin Board
  getAdminBoard() {
    return axios.get(`${API_URL}admin/users`, { headers: authHeader() });
  }

  getUserInfoByUserId(id) {
    return axios.get(`${API_URL}admin/details/${id}`, { headers: authHeader() });
  }

  deleteUserProfile(id) {
    return axios.delete(`${API_URL}admin/users/${id}`, { headers: authHeader() });
  }
  
}

export default new UserService();
