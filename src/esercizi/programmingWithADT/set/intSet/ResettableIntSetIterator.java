package esercizi.programmingWithADT.set.intSet;

import java.util.*;

/**
 * MISSION is to provide an iterator over the elements
 * of an UnorderedIntSet.
 * Once the iterator is created, if the original set changes
 * the iterator continues to work on the original copy.
 */
public class ResettableIntSetIterator implements Iterator<Integer> {
    /** INVARIANT
     * elements contains a copy of the elements of the UnorderedIntSet when
     * this iterator is created.
     * current is a valid index in elements and is the
     * index i such that elements[i] is the first of the elements
     * not yet returned.
     */
    private int current;
    final private Vector<Integer> elements;
    /**
     * @param elts an UnorderedIntSet REQUIRE not null
     * Initialize the iterator with the size of the vector and
     * with current index=0, and store a copy of the elements.
     */
    @SuppressWarnings("unchecked")
    ResettableIntSetIterator(Vector<Integer> elts){
        Objects.requireNonNull(elts);
        this.elements = (Vector<Integer>) elts.clone();
        this.current = 0;
    }
    @Override
    public boolean hasNext() {
        assert this.elements!=null;
        return (this.current < this.elements.size());
    }
    @Override
    public Integer next() {
        assert this.elements!=null;
        if (this.current < this.elements.size()){
            Integer res = this.elements.get((int) this.current);
            this.current++;
            return (res);
        } else {
            throw new NoSuchElementException("Went beyond the available values");
        }
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    /**
     * MODIFY change the current index and set it to 0.
     */
    public void reset(){
        assert this.elements!=null;
        this.current=0;
    }
}
