import axios from 'axios';

const EMPLOYEE_API_BASE_URL = 'http://localhost:8090/tutorials';

class EmployeeService {

  tutorials() {
    return axios.get(EMPLOYEE_API_BASE_URL);
  }
}

export default new EmployeeService();