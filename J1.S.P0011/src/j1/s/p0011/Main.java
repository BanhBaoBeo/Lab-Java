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
public class Main {

    public static void main(String[] args) {

        int input = Integer.parseInt(
                View.getStringByRegex("Enter Base of Input(2,10,16): ", Controler.BASE_ACCEPT)
        );
        String inputString = "";
        switch (input) {
            case 2:
                inputString = View.getStringByRegex("Enter Bin: ", Controler.BIN_PATTERN);
                break;
            case 10:
                inputString = View.getStringByRegex("Enter Dec: ", Controler.DEC_PATTERN);
                break;
            case 16:
                inputString = View.getStringByRegex("Enter Hex: ", Controler.HEX_PATTERN);
                break;
        }
        BigInteger decValue = Controler.toDec(inputString, input);
        int output = Integer.parseInt(
                View.getStringByRegex("Enter Base of Output: (2,10,16)", Controler.BASE_ACCEPT)
        );
        String outputString = Controler.toAll(decValue, output);
        System.out.println("Output: " + outputString);

    }
}
