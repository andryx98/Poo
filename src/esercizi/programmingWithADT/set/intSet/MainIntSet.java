package esercizi.programmingWithADT.set.intSet;

import java.util.*;
public class MainIntSet {
    public static void main(String[] args) {
//esempio_con_IntSet();
        try {
            esempio_con_MaxIntSet();
        } catch (EmptyIntSetException e) {
            e.printStackTrace();
        }
    }
    private static void esempio_con_MaxIntSet() throws EmptyIntSetException {
        System.out.format("\n\n\n Esempi con MaxIntSet\n");
        int [] a = {1,2,3};
        MaxIntSet s2 = new MaxIntSet(a);
        s2.insert(13);
        s2.insert(8);
        Iterator<Integer> it2 = s2.iterator();
        for (int i=0; it2.hasNext(); i++){
            System.out.format("\ns2[%d]=%d", i,it2.next());
        }
        System.out.format("\nmax di s2=%d", s2.max());
        s2.remove(13);
        it2 = s2.iterator();
        for (int i=0; it2.hasNext(); i++){
            System.out.format("\ns2[%d]=%d", i,it2.next());
        }
        System.out.format("\nmax di s2=%d", s2.max());
        s2.remove(1);
        System.out.format("\nmax di s2=%d", s2.max());
    }
    private static void esempio_con_IntSet() {
        IntSet s1 = new IntSet();
        s1.insert(1);
        s1.insert(3);
        s1.insert(2);
        s1.insert(2);
        boolean found = s1.isIn(2);
        found = s1.isIn(10);
        int [] a = {1,2,3};
        IntSet s2 = new IntSet(a);
        IntSet s3 = new IntSet();
        try {
            int z;
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s3.choose();
        } catch (EmptyIntSetException e) {
            e.printStackTrace();
        }
        boolean same = s1.equals(s2);
        System.out.format("\nEquals = %s", same);
        // NB for mutable objects, equals returns false even if they have same state
        same = s1.sameValues(s2);
        System.out.format("\nSameValues = %s", same);
        System.out.format("\ns1 hascode=%s", s1.hashCode());
        System.out.format("\ns2 hascode=%s", s2.hashCode());
        s1.insert(13);
        System.out.format("\ns1 hascode=%s", s1.hashCode());
        IntSet s4 = new IntSet(s1);
        System.out.format("\ns4 hascode=%s", s4.hashCode());
        s4.insert(33);
// ==================== resettable iterator =======================
// print all items
        ResettableIntSetIterator it = s4.resettableIntSetIterator();
        for (int i=0; it.hasNext(); i++){
            System.out.format("\ns4[%d]=%d", i,it.next());
        }
// compute the sum
        int tot = 0;
        it.reset();
        for (int i=0; it.hasNext(); i++){
            tot = tot+it.next();
        }
        System.out.format("\ntot=%d", tot);
// compute the sum of x^2 s.t. x<k
        int tot2 = 0;
        int k = 10;
        it.reset();
        for (int i=0; it.hasNext(); i++){
            Integer x = it.next();
            if (x<k){
                tot2 = tot2+x*x;
            }
        }
        System.out.format("\ntot2=%d", tot2);
// ==================== generic iterator =======================
// print all items
        Iterator<Integer> it2 = s4.iterator();
        for (int i=0; it2.hasNext(); i++){
            System.out.format("\ns4[%d]=%d", i,it2.next());
        }
// compute the sum
        it2 = s4.iterator();// need to create a new iterator
        tot = 0;
        for (int i=0; it2.hasNext(); i++){
            tot = tot+it2.next();
        }
        System.out.format("\ntot=%d", tot);
// compute the sum of x^2 s.t. x<k
        tot2 = 0;
        k = 10;
        it2 = s4.iterator();
        for (int i=0; it2.hasNext(); i++){
            Integer x = it2.next();
            if (x<k){
                tot2 = tot2+x*x;
            }
        }
        System.out.format("\ntot2=%d", tot2);
    }
}
