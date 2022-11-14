
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author BBBGARDEN
 */
public class Main {
    //Check ngày tháng 
     public static Date getDate(String msg) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        Date d= new Date();
        SDF.setLenient(false);
        do{
            System.out.print(msg);
            String s =scanner.nextLine();
            
            try {
                d = SDF.parse(s);
                return d;
            } catch (Exception e) {
                System.out.println("Unparseable date");
            }
        }while(true); 
    }
     //So sánh hai ngày 
    public static void compareDate(Date a,Date b){
        if(a.compareTo(b)>0) System.out.println("Date 1 is after Date 2");
        else System.out.println("Date 1 is before Date 2");
        
    }  
    public static void main(String[] args)  {
        SimpleDateFormat SDF = new SimpleDateFormat("EEEE");        
        Date d1=getDate("Please enter the first date: ");//Nhâpj 2 ngày 
        Date d2=getDate("Please enter the second date: ");
        compareDate(d1, d2);
    }
}
