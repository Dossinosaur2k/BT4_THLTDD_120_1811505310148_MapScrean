package com.example.ktcuoi;

public class EmployeeDataUtils {
    public static Employee[] getEmployee(){
        Employee emp1 = new Employee("Đà nẵng");
        Employee emp2 = new Employee("Thành phố Hồ Chí Minh");
        Employee emp3 = new Employee("Hà Nội");
        Employee emp4 = new Employee("Quảng Nam");
        Employee emp5 = new Employee("Khánh Hòa");
         return new Employee[]{emp1,emp2,emp3,emp4,emp5};
    }
}
