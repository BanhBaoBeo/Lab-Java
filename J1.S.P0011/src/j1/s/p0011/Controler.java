/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.math.BigInteger;

/**
 *
 * @author BBBGARDEN
 */
public class Controler {

    public final static String BIN_PATTERN = "^[01]+$";
    public final static String DEC_PATTERN = "^[0-9]+$";
    public final static String HEX_PATTERN = "^[0-9a-fA-F]+$";
    public final static String BASE_ACCEPT = "^(2|10|16)$";

    public final static char[] Mydigits
            = {'0', '1', '2', '3', '4', '5', '6', '7', '8','9', 
                'a', 'b', 'c', 'd', 'e', 'f'};
    // Trả về giá trị của kí tự 
    public static int ValueOfChar(char c) {
        for (int i = 0; i < Mydigits.length; ++i) {
            if ((c + "").equalsIgnoreCase(Mydigits[i] + "")) {
                return i;
            }
        }
        return -1;
    }
    //Đổi từ All sang Decimal 
    public static BigInteger toDec(String s, int all) {
        BigInteger Dec = new BigInteger("0");//Dec để lưu số sau khi chuyển 
        BigInteger power = new BigInteger("1");//Power tính lũy thừa như 16^1 , 2^8,...
        for (int i = s.length() - 1; i >= 0; --i) { //Duyệt từ cuối lên đầu Vd 01011 sẽ duyệt từ 1-1-0-1-0
            if (s.charAt(i) != '0') {//Nếu như kí tự thứ i khác 0 thì sẽ tính 
                BigInteger VoC = BigInteger.valueOf(ValueOfChar(s.charAt(i)));//Giá trị tại i ví dụ tại i , a=10 
                Dec = Dec.add(power.multiply(VoC));// Giá trị của Dec sau khi lấy giá trị tại i nhân lũy thừa tại nó 
            }
                power = power.multiply(BigInteger.valueOf(all)); //giá trị lũy thừa tăng lên Vd 1-16-16^2-16^3
        }
        return Dec;
    }
    //Đổi từ Decimal sang All 
    public static String toAll(BigInteger Dec, int all) {
        StringBuilder All = new StringBuilder("");//All để lưu sau khi chuyển 
        BigInteger a = BigInteger.valueOf(all);// hệ số cần chuyển như 2,10,16
        do {
            BigInteger temp[] = Dec.divideAndRemainder(a);// hàm divideandRemainder trả về [0] là thương , [1] là dư 
            char t = Mydigits[Integer.parseInt(temp[1].toString())];// Gán giá trị dư vào t
            All.insert(0, t);//thêm giá trị t vào đầu của All 
            if (temp[0].equals(new BigInteger("0"))) {//chaỵ đến khi nào thương bằng 0 thì trả về all 
                return All.toString();
            }
            Dec = Dec.divide(a);//giá trị của Dec sau khi chia cho a 
        } while (true);
    }
}
