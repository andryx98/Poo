package visibility_test.pkg1;

public class Test1 {
    int a = 10;
    double b = 3.14;
    String c = "Messaggio Test1";

    public int getA1() {
        return a;
    }

    public double getB1() {
        return b;
    }

    public String getC1() {
        return c;
    }
}

class SubTest1 {
    public void modify() {
        Test1 t = new Test1();
    }
}