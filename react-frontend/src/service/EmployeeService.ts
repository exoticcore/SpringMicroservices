import axios from 'axios';

const EMPLOYEE_SERVICE_BASE_URL = 'http://localhost:9191/api/employees';

const EMPLOYEE_ID = 2;

class EmployeeService {
  getEmployee() {
    return axios.get('http://localhost:9191/api/employees/2');
  }
}

export default new EmployeeService();
