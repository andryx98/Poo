package esercizi.programmingWithADT;

import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class IntBag {
    /** This class provides an ADT for sets of int. IntBag is mutable, unbounded. */
    /**
     * INVARIANT element != null & element contains no duplicates & * element contains boxed int (Integer).
     * Elements is not sorted.
     */
    private Vector<Integer> element;

    /**
     * EFFECT; initialize this to a new set, empty.
     */
    public IntBag() {
        this.element = new Vector<Integer>();
    }

    /**
     * @param: elts. REQUIRE be null. EFFECT initialize this to a new set, which contains each element of elts; duplicated element are not considered.
     */
    public IntBag(int[] elts) {
        this.element = new Vector<Integer>();
        Objects.requireNonNull(elts);
        for (int x : elts) {
            Integer y = new Integer(x);
            this.element.addElement(y);
        }
    }

    /**
     * Copy constructor. * @param s: a set to be duplicated * EFFECT initialize this to a new set that contains all and only
     * 1
     * the element of s.
     */
    @SuppressWarnings("unchecked")
    public IntBag(IntBag s) {
        Objects.requireNonNull(s);
        this.element = (Vector<Integer>) s.element.clone();
    }

    /**
     * MODIFY this: x is added to this set if x is not present
     */
    public void insert(int x) {
        assert (this.element != null);
        Integer y = new Integer(x);
        this.element.addElement(y);

    }

    /**
     * MODIFY this: x is removed to this set if x is present @return: true if x was removed
     */
    public boolean remove(int x) {
        assert (this.element != null);
        Integer y = new Integer(x);
        boolean res = this.element.remove(y);
        return (res);
    }

    /**
     * @return: true if x is present in this
     */
    public boolean isIn(int x) {
        assert (this.element != null);
        Integer y = new Integer(x);
        int i = this.indexOf(y);
        boolean res = (i >= 0);
        return (res);
    }

    /**
     * @return: the index of x if it is present in this ; return -1 if not present
     */
    private int indexOf(Integer x) {
        assert (this.element != null);
        for (int i = 0; i < this.element.size(); i++) {
            if (this.element.get(i).equals(x)) {
                return (i);
            }
        }
        return (-1);
    }

    /**
     * @return: the number of element in this
     */
    public long size() {
        assert (this.element != null);
        return (this.element.size());
    }

    /**
     * @return: a random element in this
     * @throws: EmptyIntSetException if this is empty
     */
    public int choose() throws EmptyIntBagException {
        assert (this.element != null);
        String msg = "L'insieme è vuoto";
        if (this.element.isEmpty()) {
            throw new EmptyIntBagException(msg);
        }
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(this.element.size());
        return (this.element.elementAt(x));
    }

    /**
     * @param s2: REQUIRE not null * @return true if this and s2 contain the same set of int
     */
    public boolean sameValues(IntBag s2) {
        Objects.requireNonNull(s2);
        Collections.sort(this.element);// BEWARE integers are moved
        Collections.sort(s2.element);
        boolean res = this.element.equals(s2.element);
        return (res);
    }

    public String toString() {
        String message = "{";
        for (int i = 0; i < element.size(); i++) {
            message = message + element.get(i) + ", ";
        }
        message = message.substring(0,message.length()-2) + "}";
        return message;
    }
}
