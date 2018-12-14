package esercizi.programmingWithADT;
import java.util.*;
public class MainIntSet {
    public static void main(String[] args) {
        try {
            int[] elts = {8,7,6,5,4,3,2,1};
            IntSet a = new IntSet(elts);
            System.out.println(a.toString());
            System.out.println(a.choose());
            Iterator<Integer> it = a.iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }

        } catch (EmptyIntSetException eise) {
            eise.printStackTrace();
        }
    }
}
