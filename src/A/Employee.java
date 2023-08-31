package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User implements Manage<Employee>, Serializable {

    private int Age;
    private String Phone;
    private double Salary;
    private static ArrayList<Employee> Employees = new ArrayList();
    private static final String EMPLOYEES_FILE_PATH = "Employees.bin";

    public Employee() {

    }

    public Employee(String Username, String Password, String Frist_name, String Last_name, String Gender, int Age, String Phone, double Salary, String Id) {
        super(Username, Password, Frist_name, Last_name, Gender, Id);
        this.Age = Age;
        this.Phone = Phone;
        this.Salary = Salary;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public boolean putInFile() {
        return Database.input(EMPLOYEES_FILE_PATH, Employees);
    }

    @Override
    public void getFromFile() {
        Employees = (ArrayList<Employee>) Database.output(EMPLOYEES_FILE_PATH);
        if (Employees == null) {
            Employees = new ArrayList();
        }
    }

    @Override
    public void add() {
        getFromFile();
        Employees.add(this);
        putInFile();
    }

    @Override
    public int search(String id) {
        getFromFile();
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean delete(String EmployeeId) {
        int index = search(EmployeeId);
        if (index != -1) {
            Employees.remove(index);
            return putInFile();
        }
        return false;
    }

    @Override
    public void update(String Old_Employee_Id, Employee New_Data) {
        Employees.get(search(Old_Employee_Id)).delete(Old_Employee_Id);
        New_Data.add();
    }

    @Override
    public ArrayList<Employee> list() {
        getFromFile();
        return Employees;
    }

    public Employee getEmployee(String id) {
        int index = search(id);
        if (index != -1) {
            return Employees.get(index);
        }
        return null;
    }

    public void addCustomer(Customer x) {
        x.add();
    }

    public void deleteCustomer(String customer_id) {
        new Customer().delete(customer_id);
    }

    public Customer searchCustomer(String customer_id) {
        return new Customer().getCustomer(customer_id);
    }

    public ArrayList<Order> getOrdersIndexse(String customerId) {
        return new Order().searchCustomerOrders(customerId);
    }

    public void updateCustomer(String old_customer_id, Customer new_customer) {
        new Customer().update(old_customer_id, new_customer);
    }

    public ArrayList<Customer> listCustomer() {
        return new Customer().list();
    }

    public void makeOrder(Order x) {
        x.add();
    }

    public void cancelOrder(String order_id) {
        new Order().delete(order_id);
    }

    public boolean login(String UserName, String Password) {
        getFromFile();
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getUsername().equals(UserName) && Employees.get(i).getPassword().equals(Password)) {
                return true;
            }

        }
        return false;
    }
}
