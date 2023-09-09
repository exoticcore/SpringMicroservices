import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

interface StateInterface {
  employee: {
    firstName?: String;
    lastName?: String;
    email?: String;
  };
  department: {};
  organization: {};
}

export class EmployeeComponent extends Component {
  state: StateInterface;

  constructor(props: {} | Readonly<{}>) {
    super(props);

    this.state = {
      employee: {},
      department: {},
      organization: {},
    };
  }

  componentDidMount(): void {
    EmployeeService.getEmployee().then((response) => {
      this.setState({ employee: response.data?.employee });
      this.setState({ department: response.data?.departmant });
      this.setState({ organization: response.data?.organization });

      console.log(this.state.employee);
      console.log(this.state.department);
      console.log(this.state.organization);
    });
  }

  render() {
    return (
      <div>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center card-header">View Employee Details</h3>
          <div className="card-body">
            <div className="row">
              <p>
                <strong>Employee First Name: </strong>{' '}
                {this.state.employee.firstName}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Employee Last Name: </strong>{' '}
                {this.state.employee.lastName}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Employee Email: </strong> {this.state.employee.email}
              </p>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default EmployeeComponent;
