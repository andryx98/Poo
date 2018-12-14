package esercizi.programmingWithADT;

public class MainIntBag {
    public static void main(String[] args) {
        try {
            int[] elt = {1, 1, 1, 2, 2, 2, 3, 4, 5, 6, 3, 4, 5, 6};
            IntBag b = new IntBag(elt);
            System.out.println(b.toString());
            System.out.println(b.choose());
        } catch (EmptyIntBagException eibe) {
            eibe.printStackTrace();
        }
    }
}
