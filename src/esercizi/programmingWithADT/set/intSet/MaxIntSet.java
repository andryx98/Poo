package esercizi.programmingWithADT.set.intSet;

import java.util.*;

/**
 * MISSION of this class is to provide a specialized version
 * of UnorderedIntSet with the ability to quickly compute the maximum value
 * of the set.
 *
 */
public class MaxIntSet extends IntSet {
    private Integer highestValue = null;
    /**
     * ABSTRACTION FUNCTION: the same as UnorderedIntSet
     * @see IntSet
     *
     * INVARIANT: when this set is not empty then this.highestValue contains the
     * maximum value of the set. If the set is empty then highestValue=null.
     * @return true if the invariant of this class holds
     */
    private boolean invariantOK(){
        boolean res = ((highestValue!=null) == (this.size()>0));
        return (res);
    }

    /**
     * EFFECT: initialize a new instance of MaxIntSet
     * with the values stored in s.
     * @param s: an UnorderedIntSet, REQUIRE not null
     */
    public MaxIntSet(IntSet s){
        super(s);
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()){
            Integer x = it.next();
            if (highestValue == null || highestValue < x){
                highestValue = x;
            }
        }
        assert invariantOK(): "highestValue==null implies empty set";
    }
    /**
     * EFFECT: initialize the instance this with the values stored in
     * data. Avoid creating duplicates.
     * @param data: a list of ints, REQUIRE not null
     */
    public MaxIntSet(int[] data){
        super(data);
        for(int i=0; i<data.length;i++){
            if (highestValue==null||highestValue< data[i]){
                highestValue = new Integer(data[i]);
            }
        }
        assert invariantOK(): "highestValue==null iff empty set";
    }
    /** insert x in this
     * MODIFY this: x is added to this set if x is not present
     */
    public void insert(int x){
        assert invariantOK(): "highestValue==null iff empty set";
        super.insert(x);
        if (highestValue == null || highestValue < x){
            highestValue = new Integer(x);
        }
        assert invariantOK(): "highestValue==null iff empty set";
        assert (highestValue >= x);
    }

    /** remove x from this
     * MODIFY this: x is removed to this set if x is present
     * @return: true if x was removed
     */
    public boolean remove(int x){
        assert invariantOK(): "highestValue==null iff empty set";
        assert (highestValue >= x);
        boolean res = super.remove(x);
        if (highestValue == null || x < highestValue ){
// nothing to do
        } else { // reset the highest value by scanning all values
            Iterator<Integer> it = this.iterator();
            highestValue = it.next();
            while (it.hasNext()){
                Integer z = it.next();
                if (highestValue < z){
                    highestValue = z;
                }
            }
        }
        assert invariantOK(): "highestValue==null iff empty set";
        return (res);
    }
    /**
     * @return the maximum value of the set
     * @throws EmptyIntSetException if the set is empty
     */
    public int max() throws EmptyIntSetException{
        String message = "L'insieme di interi è vuoto!";
        assert invariantOK(): "highestValue==null iff empty set";
        if (highestValue == null){
            throw new EmptyIntSetException(message);
        }
        return highestValue.intValue();
    }
}
