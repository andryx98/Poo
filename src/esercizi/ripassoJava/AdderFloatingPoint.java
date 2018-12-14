package esercizi.ripassoJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AdderFloatingPoint {
    public static void main(String[] args) {
        float k = 0;
        for (int i=0; i<args.length; i++) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter your number: ");
                String x = reader.readLine();
                k = k + Float.parseFloat(x);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        System.out.println("Your total is: " + k);
    }
}