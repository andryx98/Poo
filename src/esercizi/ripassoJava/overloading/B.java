package esercizi.ripassoJava.overloading;

public class B extends C {
    void m(Object o, long x, long y) {
        System.out.print("B1");
    } // B1

    void m(String s, int x, long y) {
        System.out.print("B2");
    } // B2

    void m(Object o, int x, long y) {
        System.out.print("B3");
    } // B3

    void m(String s, long x, int y) {
        System.out.print("B4");
    } // B4
}
