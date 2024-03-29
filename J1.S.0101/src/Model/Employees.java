/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author BBBGARDEN
 */
public class Employees {
   
    private String[] TYPESEX = {"M", "FM", "LGBT"};

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private Date DOB;
    private int sex; //1 ,2 ,3
    private double salary;
    private String Egency;

    public Employees() {
    }

    public Employees(String id, String firstName, String lastName,
            String phone, String email, String address, Date DOB, int sex, double salary, String Egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.Egency = Egency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return Egency;
    }

    public void setEgency(String Egency) {
        this.Egency = Egency;
    }

    @Override
    public String toString() {

        return String.format("%-15s|%-25s|%-15s|%-15s|%-30s|%-15s|%-15s|%-15s|%-10.2f|%-10s|\n",
                this.getId(),
                this.getLastName(),
                this.getFirstName(),
                this.getPhone(),
                this.getEmail(),
                this.getAddress(),
                SDF.format(this.getDOB()),
                this.TYPESEX[this.getSex() - 1],
                this.getSalary(),
                this.getEgency()
        );
    }

    public void display() {
        System.out.println(toString());
    }
     public int compareTo(Employees o) {

        if (this.getSalary() < o.getSalary()) {
            return -1;
        } else if (this.getSalary() > o.getSalary()) {
            return 1;
        } else {
            return 0;
        }
    }
  

}

