/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controler;
import Controller.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int choice;
        double xFrom = 0, xTo = 0;
        Controler m = new Controler();
        do {
            System.out.println("---------------TASK PROGRAM-------------\n"
                    + "1. Add Task\n"
                    + "2. Delete Task\n"
                    + "3. Display Task\n"
                    + "4. Exist\n");
            choice = Validation.getInt("Enter choice: ", 1, 4);
            switch (choice) {
                case 1:

                    System.out.println("\n---------------TASK TYPE----------------\n1.Code\n2.Test\n3.Design\n4.Review\n");
                    int xTaskTypeID = Validation.getInt("Enter Task Type: ", 1, 4);
                    String xRequiredmentName = Validation.getString("Enter Requiredment Name: ", false);
                    Date xDate = Validation.getDate("Enter Date: ");
                    xFrom = Validation.getDouble("Enter From( number format .0 or .5 )range 8.0->17.0: ", 8.0, 17.0);
                    xTo = Validation.getDouble("Enter To( number format .0 or .5 ) range " + (xFrom + 0.5) + "->17.5: ", xFrom + 0.5, 17.5);
                    String xAssignee = Validation.getString("Enter Assignee: ", false);
                    String xReviewer = Validation.getString("Enter xReviewer: ", false);
                    System.out.println("");
                    System.out.println("Add successfull!\n\n");
                    m.addTask(xTaskTypeID, xRequiredmentName, xDate, xFrom, xTo, xAssignee, xReviewer);

                    break;
                case 2:
                    if (m.listEmpty() < 0) {
                        System.out.println("List don't have Task, you can add ");
                        break;
                    }
                    int id = Validation.getInt("Enter id of Task you want delete: ", 1, Integer.MAX_VALUE);
                    if (m.deleteTask(Integer.toString(id)) < 0) {
                        System.out.println("ID don't exist.");
                    } else {
                        System.out.println("\nDelete successfull!\n");
                    }
                    System.out.println("");
                    break;

                case 3:
                    if(m.listEmpty()<0){
                        System.out.println("\nList don't have Task, you can add \n\n");
                        break;
                    }
                    System.out.println("          --------------------------Task descending order-------------------------------");
                    System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "TaskType", "Date", "Time", "Assignee", "Reviewer");
                    m.displayTask();
                    System.out.println("\n\n");
                    break;
            }
        } while (choice != 4);
    }

}

