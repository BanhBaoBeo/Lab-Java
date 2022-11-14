/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Controller.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author BBBGARDEN
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Controller c = new Controller();
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        c.add("He163235", "Lam", "Nguyen Duc Hoang", "0121348657", "lamdh@fpt.edu.vn", "Ha Noi", SDF.parse("5/2/2002"), 1, 11234.25, "FPT");
        c.add("He123122", "Hieu", "Tran Minh", "0987264138", "hieutm@fpt.edu.vn", "Bac Giang", SDF.parse("6/12/2002"), 3, 1000, "FPT");
        c.add("He123684", "Khanh", "Tran Dinh", "0874935816", "khannhtd@fpt.edu.vn", "Bac Ninh", SDF.parse("7/2/2002"), 1, 11234.25, "FPT");
        c.add("He121212", "Ngo", "Le Hong", "0378512684", "ngolh@fpt.edu.vn", "Ha Nam", SDF.parse("4/2/2002"), 2, 122, "FPT");

        int choice;
        String xId;
        String xFirstName;
        String xLastName;
        String xPhone;
        String xEmail;
        String xAddress;
        Date xDOB;
        int xSex;
        double xSalary;
        String xEgency;
        do {//Cho người dùng lựa chọn 
            System.out.println("Main menu:\n"
                    + "1. Add employees \n"
                    + "2. Update employees\n"
                    + "3. Remove employees\n"
                    + "4. Search employees\n"
                    + "5. Sort employees by salary\n"
                    + "6. Display\n"
                    + "7. Exit\n");
            choice = Validation.getInt("Enter your choice: ", 1, 7);

            switch (choice) {
                case 1://Thêm employee
                    xId = Validation.getString("Enter id: ", false);
                    if (c.findID(xId) < 0) { //Nếu Id không tồn tại thì add,còn không thì thông báo ID không tôn tại 
                        xFirstName = Validation.getString("Enter first name: ", false);
                        xLastName = Validation.getString("Enter last name: ", false);
                        xPhone = Validation.getStringByRegex("Enter phone: ", Validation.PHONE_PATTERN);
                        xEmail = Validation.getStringByRegex("Enter email: ", Validation.EMAIL_PATTERN);
                        xAddress = Validation.getString("Enter address: ", false);
                        xDOB = Validation.getDate("Enter date of bird: ", "dd/MM/yyyy");
                        xSex = Validation.getInt("Enter sex: ", 1, 3);
                        xSalary = Validation.getDouble("Enter salary: ", 0.0001, Double.POSITIVE_INFINITY);
                        xEgency = Validation.getString("Enter Egency: ", false);
                        c.add(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, xEgency);
                        System.out.println("---------Add successful---------");
                    } else {
                        System.out.println("---------This ID has existed!---------");
                    }
                    break;
                case 2://Update Employee 
                    xId = Validation.getString("Enter id: ", false);
                    if (c.findID(xId) > 0) {//Nếu tồn tại ID thì cho update, ko thì báo là không có ID
                        System.out.println("---------Update menu---------\n"//Cho lựa chọn Update all or cái mình muốn
                                + "1.Update All\n"
                                + "2.Update First Name\n"
                                + "3.Update Last Name\n"
                                + "4.Update Phone\n"
                                + "5.Update Email\n"
                                + "6.Update Address\n"
                                + "7.Update DOB\n"
                                + "8.Update Sex\n"
                                + "9.Update Salary\n"
                                + "10.Update Egency\n"
                        );
                        int choice2 = Validation.getInt("Enter choice: ", 1, 10);

                        switch (choice2) {
                            case 1://Update All
                                xFirstName = Validation.getString("Enter First Name: ", false);
                                xLastName = Validation.getString("Enter Last Name: ", false);
                                xPhone = Validation.getStringByRegex("Enter Phone: ", Validation.PHONE_PATTERN);
                                xEmail = Validation.getStringByRegex("Enter Email: ", Validation.EMAIL_PATTERN);
                                xAddress = Validation.getString("Enter Address: ", false);
                                xDOB = Validation.getDate("Enter Date of Bird: ", "dd/MM/yyyy");
                                xSex = Validation.getInt("Enter Sex: ", 1, 3);
                                xSalary = Validation.getDouble("Enter Salary: ", 0.0001, Double.POSITIVE_INFINITY);
                                xEgency = Validation.getString("Enter Egency: ", false);
                                c.updateAll(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, xEgency);
                                System.out.println("----------Update successfull-----------");
                                break;
                            case 2://Update First Name  
                                xFirstName = Validation.getString("Enter First Name: ", false);
                                c.updateFirstName(xId, xFirstName);
                                System.out.println("----------Update successfull-----------");
                                break;
                            case 3://Update Last Name 
                                xLastName = Validation.getString("Enter Last Name: ", false);
                                c.updateLastName(xId, xLastName);
                                System.out.println("----------Update successfull-----------");
                                break;
                            case 4://Update SDT
                                xPhone = Validation.getStringByRegex("Enter Phone: ", Validation.PHONE_PATTERN);
                                c.updatePhone(xId, xPhone);
                                System.out.println("----------Update successfull-----------");
                                break;
                            case 5://Update Email 
                                xEmail = Validation.getStringByRegex("Enter Email: ", Validation.EMAIL_PATTERN);
                                c.updateEmail(xId, xEmail);
                                System.out.println("----------Update successfull-----------");
                                break;
                            case 6://Update địa chỉ 
                                xAddress = Validation.getString("Enter Address: ", false);
                                c.updateAddress(xId, xAddress);
                                System.out.println("----------Update successfull-----------");
                                break;
                            case 7://Update ngày tháng 
                                xDOB = Validation.getDate("Enter Date of Bird: ", "dd/MM/yyyy");
                                c.updateDOB(xId, xDOB);
                                System.out.println("----------Update successfull-----------");
                                break;

                            case 8://Update giới tinh
                                xSex = Validation.getInt("Enter Sex: ", 1, 3);
                                c.updateSex(xId, xSex);
                                System.out.println("----------Update successfull-----------");
                                break;

                            case 9://Update lương 
                                xSalary = Validation.getDouble("Enter Salary: ", 0.0001, Double.POSITIVE_INFINITY);
                                c.updateSalary(xId, xSalary);
                                System.out.println("----------Update successfull-----------");
                                break;

                            case 10://Update chỗ làm 
                                xEgency = Validation.getString("Enter Egency: ", false);
                                c.updateEgency(xId, xEgency);
                                System.out.println("----------Update successfull-----------");
                                break;
                        }
                    } else {
                        System.out.println("---------This ID doesn't exist!---------");
                    }

                    break;
                case 3://Remove nhân viên 
                    xId = Validation.getString("Enter id: ", false);
                    if (c.findID(xId) >= 0) {//Nếu ID tồn tại thì remove , còn không có thì thông báo không có ID 
                        c.remove(xId);
                        System.out.println("-----------Remove successful------------");
                    } else {
                        System.out.println("---------This ID doesn't exist!---------");
                    }
                    break;
                case 4://Tìm nhân viên
                    String tempName = Validation.getString("Input name need search : ", true);
                    c.search(tempName);
                    break;
                case 5://Sắp xếp theo lương
                    c.sortBySalary();
                    System.out.println("----------Sort successful----------");
                    break;
                case 6://Hiển thị 
                    c.display();
                    break;
            }
        } while (choice != 7);
    }
}
