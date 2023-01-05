package com.km.inclassactivity2.model;

public class Employee {
    private String name;
    private double salary;
    private String fullTime;

    public Employee(String name, double salary, String fullTime) {
        this.name = name;
        this.salary = salary;
        this.fullTime = fullTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFullTime() {
        return fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "  salary=" + salary +
                "   status:'" + fullTime + '\'';
    }
}
