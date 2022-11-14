
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author BBBGARDEN
 */
public class Main {
    //Check Ngày Tháng 
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
    public static void main(String[] args)  {
        SimpleDateFormat SDF = new SimpleDateFormat("EEEE");        
        Date d=getDate("Please enter date with format [dd/mm/yyyy]: ");//Nhập ngày tháng năm 
        System.out.println("Your day is "+SDF.format(d));//In ra thứ 
    }
}
