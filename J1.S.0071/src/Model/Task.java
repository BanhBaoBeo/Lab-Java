
package Model;
import java.util.*;
import java.text.SimpleDateFormat;
public class Task {
    private static String[] TaskType={"Code","Test","Design","Review"};
    SimpleDateFormat a= new SimpleDateFormat("dd-MM-yyyy");
    private int ID;
    private int TaskTypeID;
    private String RequiredmentName;
    private Date xDate;
    private double From;
    private double To;
    private String Assignee;
    private String Reviewer;

    public Task() {
    }

    public Task(int ID, int TaskTypeID, String RequiredmentName, Date xDate, double From, double To, String Assignee, String Reviewer) {
        this.ID = ID;
        this.TaskTypeID = TaskTypeID;
        this.RequiredmentName = RequiredmentName;
        this.xDate = xDate;
        this.From = From;
        this.To = To;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }
    
    public static String[] getTypeTask() {
        return TaskType;
    }
    public int getID() {
        return ID;
    }
    public int getTaskTypeID() {
        return TaskTypeID;
    }
    public String getRequiredmentName() {
        return RequiredmentName;
    }
    public Date getxDate() {
        return xDate;
    }
    public double getFrom() {
        return From;
    }
    public double getTo() {
        return To;
    }
    public String getAssignee() {
        return Assignee;
    }
    public String getReviewer() {
        return Reviewer;
    }
    public static void setTypeTask(String[] typeTask) {
        Task.TaskType = typeTask;
    }
    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }
    public void setRequiredmentName(String RequiredmentName) {
        this.RequiredmentName = RequiredmentName;
    }
    public void setxDate(Date xDate) {
        this.xDate = xDate;
    }
    public void setFrom(double From) {
        this.From = From;
    }
    public void setTo(double To) {
        this.To = To;
    }
    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }
    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    @Override
    public String toString() {
        return String.format("%-15d%-15s%-15s%-15s%-15.1f%-15s%-15s",ID,TaskType[this.TaskTypeID-1],RequiredmentName,a.format(xDate).toString(),this.To - this.From,Assignee,Reviewer );        
    }
    public void display(){
        System.out.println(toString());
    }
    

    
    
}

