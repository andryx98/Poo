package esercizi.programmingWithADT.polynomial;

public class PolynomialMain {
    public static void main(String[] args) {
        try {
            Polynomial p = new Polynomial(2, 2);
            Polynomial p1 = new Polynomial(2, 2);
            Polynomial p2 = new Polynomial(4, 8);
            System.out.print(p.add(p2).add(p1).toString());
        } catch (NegativeExponentException nee) {
            nee.printStackTrace();
        }
    }
}
