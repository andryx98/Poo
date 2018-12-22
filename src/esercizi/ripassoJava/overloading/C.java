package esercizi.ripassoJava.overloading;

public class C extends D {
    void m(Object o, long x, long y) {
        System.out.print("C1");
    } // C1

    void m(String s, int x, long y) {
        System.out.print("C2");
    } // C2

    void m(Object o, int x, long y) {
        System.out.print("C3");
    } // C3

    void m(String s, long x, int y) {
        System.out.print("C4");
    } // C4
}
