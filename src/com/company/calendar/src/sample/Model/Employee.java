package sample.Model;

import sample.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Denne kommer fra profile gruppen så derfor ingen konkrete kommentarer

public class Employee {

    String name;
    List<Appointment> appointmentsForEmployee = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointmentsForEmployee() {
        Collections.sort(appointmentsForEmployee);
        return appointmentsForEmployee;

    }

    public static Employee getEmployeeByName(String name){
        for (Employee employee: Main.employees) {
            if(employee.getName().equals(name)){
                return employee;
            }

        }
        return null;
    }

    public String toString(){
        return this.name;
    }
}
