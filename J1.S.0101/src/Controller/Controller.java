/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employees;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author BBBGARDEN
 */
public class Controller {

    ArrayList<Employees> myList;

    public Controller() {
        myList = new ArrayList<Employees>();
    }

    public Controller(ArrayList<Employees> myList) {
        this.myList = myList;
    }

    //Thêm employee
    public void add(String change, String firstName, String lastName,
            String phone, String email, String address,
            Date DOB, int sex, double salary, String Egency) {
        myList.add(new Employees(change, firstName, lastName, phone, email,
                address, DOB, sex, salary, Egency));
    }

    //Tìm Id 
    public int findID(String xId) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getId().equalsIgnoreCase(xId)) {
                return i;
            }
        }
        return -1;
    }

    //Sắp xếp theo lương 
    public void sortBySalary() {
        Collections.sort(myList, new Comparator<Employees>() {
            @Override
            public int compare(Employees o1, Employees o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        display();
    }

    // Xóa 
    public int remove(String xId) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getId().equalsIgnoreCase(xId)) {
                myList.remove(myList.get(i));
                return 1;
            }
        }
        return -1;
    }

    //Check trùng lặp
    public int isDuplicated(String xId) {
        if (findID(xId) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    //Display ra 
    public void display() {
        for (int i = 0; i < myList.size(); i++) {
            myList.get(i).display();
        }
    }

    // Tìm kiếm theo tên 
    public void search(String xName) {
        for (int i = 0; i < myList.size(); i++) {
            String fullName = myList.get(i).getLastName() + " " + myList.get(i).getFirstName();
            if (fullName.toLowerCase().compareTo(xName.toLowerCase()) == 0) {
                myList.get(i).display();
            }
        }

    }

    // Update tất cả
    public void updateAll(String xId, String xFirstName, String xLastName,
            String xPhone, String xEmail, String xAddress,
            Date xDOB, int xSex, double xSalary, String xEgency) {
        myList.set(findID(xId), new Employees(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, xEgency));
    }

    // Update FirstName
    public void updateFirstName(String xId, String xFirstName) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, xFirstName, myList.get(change).getLastName(), myList.get(change).getPhone(),
                myList.get(change).getEmail(), myList.get(change).getAddress(), myList.get(change).getDOB(),
                myList.get(change).getSex(), myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Updatr LastName 
    public void updateLastName(String xId, String xLastName) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), xLastName, myList.get(change).getPhone(),
                myList.get(change).getEmail(), myList.get(change).getAddress(), myList.get(change).getDOB(),
                myList.get(change).getSex(), myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Update số điện thoại 
    public void updatePhone(String xId, String xPhone) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), xPhone,
                myList.get(change).getEmail(), myList.get(change).getAddress(), myList.get(change).getDOB(),
                myList.get(change).getSex(), myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Update email 
    public void updateEmail(String xId, String xEmail) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), myList.get(change).getPhone(),
                xEmail, myList.get(change).getAddress(), myList.get(change).getDOB(),
                myList.get(change).getSex(), myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Update địa chỉ 
    public void updateAddress(String xId, String xAddress) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), myList.get(change).getPhone(),
                myList.get(change).getEmail(), xAddress, myList.get(change).getDOB(),
                myList.get(change).getSex(), myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Update Ngày tháng năm sinh 
    public void updateDOB(String xId, Date xDOB) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), myList.get(change).getPhone(),
                myList.get(change).getEmail(), myList.get(change).getAddress(), xDOB,
                myList.get(change).getSex(), myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Update giới tính 
    public void updateSex(String xId, int xSex) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), myList.get(change).getPhone(),
                myList.get(change).getEmail(), myList.get(change).getAddress(), myList.get(change).getDOB(),
                xSex, myList.get(change).getSalary(), myList.get(change).getEgency()
        ));
    }

    //Update lương 
    public void updateSalary(String xId, double xSalary) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), myList.get(change).getPhone(),
                myList.get(change).getEmail(), myList.get(change).getAddress(), myList.get(change).getDOB(),
                myList.get(change).getSex(), xSalary, myList.get(change).getEgency()
        ));
    }

    //Update Engency 
    public void updateEgency(String xId, String xEgency) {
        int change = findID(xId);
        myList.set(change, new Employees(xId, myList.get(change).getFirstName(), myList.get(change).getLastName(), myList.get(change).getPhone(),
                myList.get(change).getEmail(), myList.get(change).getAddress(), myList.get(change).getDOB(),
                myList.get(change).getSex(), myList.get(change).getSalary(), xEgency
        ));
    }
}
