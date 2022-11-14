package Controller;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
        
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Validation { 
    
    public static int getInt(String msg, int min,int max){
        int i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                i=Integer.parseInt(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
        public static double getDouble(String msg, double min, double max) {
        double i;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(msg);
            try {
                i = Double.parseDouble(sc.nextLine());
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.out.println("Out of range");
                }

            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        } while (true);
    }
    
    public static String getString(String msg,boolean isEmpty){
        
        String s;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.print(msg);
            s = sc.nextLine();
            if(isEmpty == true) return s;
            else{
                if(s.equals("")){
                    System.err.println("String must have atleast 1 character");
                    System.out.println(msg);
                } else return s;
            }
            
        } while (true);
    }

    public static Date getDate(String msg){
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy"); 
        SDF.setLenient(false);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            String sDate = sc.nextLine();
            try {
                date = SDF.parse(sDate);
                return date;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
        
    }
        public static String getStringByRegex(String msg,String Patt){
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                s = sc.nextLine();
                if(Pattern.matches(Patt,s)==true)
                    return s;
                else {
                    System.err.println("You can input form(.0 or .5)range 8.0->17.5");
                    System.out.print("Input again : ");
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);   
    }
    
}