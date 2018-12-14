package visibility_test.pkg1;

public class Test {
    private int a = 10;
    private double b = 3.14;
    private String c = "Messaggio Test";

    public int getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public void modify() {
        Test1 t = new Test1();
    }
}
