/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Controler {

    private final LinkedList<Task> mylist;

    public Controler() {
        mylist = new LinkedList<>();
    }

    public void addTask(int xTaskTypeID, String xRequiredmentName, Date xDate, double xFrom, double xTo, String xAssignee, String xReviewer) {
        int xID;
        if (mylist.isEmpty()) {
            xID = 1;
        } else {
            xID = mylist.get(mylist.size() - 1).getID() + 1;
        }
        mylist.add(new Task(xID, xTaskTypeID, xRequiredmentName, xDate, xFrom, xTo, xAssignee, xReviewer));
    }

    public int findID(int xID) {
        for (int i = 0; i < mylist.size(); ++i) {
            if (mylist.get(i).getID() == xID) {
                return i;
            }
        }
        return -1;
    }

    public int listEmpty() {
        int len = mylist.size();
        if (len > 0) {
            return 1;
        }
        return -1;
    }

    public int deleteTask(String id) throws Exception {
        int temp = findID(Integer.parseInt(id));
        if (temp < 0) {
            return -1;
        } else {
            mylist.remove(temp);
            return 1;
        }
    }

    public void displayTask() {
        for (int i = 0; i < mylist.size(); i++) {
            mylist.get(i).display();
        }
    }
}
