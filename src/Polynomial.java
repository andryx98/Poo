import esercizi.programmingWithADT.NegativeExponentException;
import esercizi.programmingWithADT.Poly;

import java.util.Iterator;
import java.util.Vector;

public class Polynomial extends Exception {
    Vector<Integer> coefficients;
    Vector<Integer> exponents;

    /**
     *  @return: a new zero poly. 
     */
    public Polynomial() {
        this.coefficients = new Vector<Integer>();
        this.exponents = new Vector<Integer>();
    }

    /**
     *   
     *
     * @param c: the coefficient
     * @param n: the exponent
     * @return: a new Polynomial c*x^n. 
     * @Throw NegativeExponentException when n<0. 
     */
    public Polynomial(int c, int n) throws NegativeExponentException {
        this.coefficients = new Vector<Integer>();
        this.exponents = new Vector<Integer>();
        if (n < 0) {
            throw new NegativeExponentException("L'esponente n: " + n + " è negativo!");
        } else {
            this.coefficients.add(c);
            this.exponents.add(n);
        }
    }

    /**
     *  
     *
     * @param p: the poly to be added to this; REQUIRE not null.
     * @return a new poly that is this+p 
     */
    public Polynomial add(Polynomial p) {
        Polynomial res = new Polynomial();
        Iterator<Integer> it1 = coefficients.iterator();
        Iterator<Integer> it2 = exponents.iterator();
        Iterator<Integer> it3 = p.coefficients.iterator();
        Iterator<Integer> it4 = p.exponents.iterator();

        /**for () {//int i = 0; i < this.coefficients.size(); i++
            res.coefficients.add(this.coefficients.get(i));
            res.exponents.add(this.exponents.get(i));
        }
        int i = 0;
        while(i<Math.max(this.exponents.size(),p.exponents.size()) && it2.hasNext() && it4.hasNext()) {
            while (!it2.next().equals(it4.next())) {
                res.coefficients.add(it3.next());
                res.exponents.add(p.exponents.get(i));
            }
            res.coefficients.set(i, it1.next()+it3.next());
            res.exponents.set(i, p.exponents.get(i));
            i++;
        } */
        return res;

    }
    /** 
     * @param p: the poly to be multiplied to this;  REQUIRE not null.
     * @return a new poly that is this*p 
     */
     public Polynomial mul(Polynomial p) {
         Polynomial res = new Polynomial();
         for (int i = 0; i < exponents.size(); i++) {
             res.coefficients.add(coefficients.get(i));
             res.exponents.add(exponents.get(i));
         }
         for (int i = 0; i < p.exponents.size(); i++) {
             res.coefficients.set(i,res.coefficients.get(i)*p.coefficients.get(i));
             res.exponents.set(i,res.exponents.get(i)*p.exponents.get(i));
         }
         return res;
     }
    /**
     * @return the largest exponent in this with non zero coeff
     */

    public int degree() {
        if (coefficients.isEmpty() && exponents.isEmpty()) {
            return 0;
        } else {
            int highest = 0;
            for (int i = 0; i < exponents.size(); i++) {
                int c = exponents.get(i);
                if (c > highest) {
                    highest = c;
                }
            }
            return highest;
        }
    }

    /**
     * @param n: an exponent.
     * @return the coefficient of the term in this  that has exponent n; possibly 0
     */
    public int coeff(int n) {
        return coefficients.get(n);
    }

    /** @return the poly ­(this) */

    public Polynomial minus() {
        Polynomial res = new Polynomial();
        for (int i = 0; i < exponents.size(); i++) {
            res.coefficients.add(i,(- coefficients.get(i)));
            res.exponents.add(i,exponents.get(i));
        }
        return res;
     }

    public String toString() {
        String msg = "";
        if (coefficients.get(0) < 0) {
            for (int i = 0; i < exponents.size(); i++) {
                msg = msg + coefficients.get(i) + "*x^" + exponents.get(i);
            }
            return msg;
        } else {
            for (int i = 0; i < exponents.size(); i++) {
                msg = msg + coefficients.get(i) + "*x^" + exponents.get(i) + "+";
            }
            return msg;
        }
    }
}
