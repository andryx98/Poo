package esercizi.ripassoJava;

import java.io.*;

public class Adder {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=0; i<args.length; i++) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter your number: ");
                String number = reader.readLine();
                sum = sum + Integer.parseInt(number);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        System.out.println("Your total is: " + sum);
    }
}
