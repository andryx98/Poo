package esercizi.programmingWithADT.polynomial;

public class PolyMain {
    public static void main(String arg[]) {
        try {
            Poly p = new Poly(2, -1);
            Poly p1 = new Poly(3, 1);
            Poly p2 = new Poly(4, 2);
            Poly p3 = new Poly(3, 5);
            Poly p4 = new Poly(10, 4);
            Poly sum = p.mul(p1).mul(p.add(p2)).mul(p3.add(p4));

            System.out.println("Il polinomio scelto: " + sum.toString());

        } catch (NegativeExponentException nee) {
            nee.printStackTrace();
        }
    }
}
