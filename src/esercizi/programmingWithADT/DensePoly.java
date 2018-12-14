package esercizi.programmingWithADT;

import java.util.TreeSet;
import java.util.Objects;
import java.util.Iterator;

public class DensePoly {
    /**
     * a record that represents a single term of the poly:
     * c * x^e
     */
    public enum TipoPolinomio {
        Monomio, Polinomio
    }

    private class PolynomialTerms implements Cloneable, Comparable {
        int coeff;
        int exponent;

        PolynomialTerms(int c, int e) {
            this.coeff = c;
            this.exponent = e;
        }

        /**
         * Copy constructor
         *
         * @param ce: REQUIRE not null
         */
        PolynomialTerms(PolynomialTerms ce) {
            ce = Objects.requireNonNull(ce);
            this.coeff = ce.coeff;
            this.exponent = ce.exponent;
        }

        @Override
        public int compareTo(Object o) {
            return term.size();
        }
    }

    /**
     * INVARIANT term = the list of term;
     * there is no relation between index of the term with exponent.
     * There can be term with c=0.
     */
    private TreeSet<PolynomialTerms> term;

    /**
     * @return: a new zero (empty) poly .
     */
    public DensePoly() {
        this.term = new TreeSet<PolynomialTerms>();
    }

    /**
     * @param c: the coefficient
     * @param n: the exponent
     * @return: a new Polynomial c*x^n if c!=0; otherwise the zero Polynomial
     * @Throws NegativeExponentException when n<0.
     */
    public DensePoly(int c, int n) throws NegativeExponentException {
        String msg = "L'esponente è negativo!";
        if (n < 0) {
            throw new NegativeExponentException(msg);
        }
        term = new TreeSet<PolynomialTerms>();
        if (c != 0) {
            PolynomialTerms ce = new PolynomialTerms(c, n);
            this.term.add(ce);
        }
    }

    /**
     * Copy constructor.
     * * @param p: REQUIRE not null
     */
    public DensePoly(DensePoly p) {
        p = Objects.requireNonNull(p);
        this.term = p.term;
    }

    public int getExponent(int i, DensePoly p) {
        for (int j = 0; j < i; j++) {
            p.term.remove(p.term.first());
        }
        return p.term.first().exponent;
    }

    public int getCoefficient(int i, DensePoly p) {
        for (int j = 0; j < i; j++) {
            p.term.remove(p.term.first());
        }
        return p.term.first().coeff;
    }

    public DensePoly set(int i, PolynomialTerms p) {
        DensePoly result = new DensePoly();
        for (int j = 0; j < i; j++) {
            this.term.remove(this.term.first());
        }
        this.term.add(p);
        result.term.addAll(this.term);
        return result;
    }

    /**
     * @param p: the poly to be added to this; REQUIRE not null.
     * @return a new poly that is this+p
     */
    public DensePoly add(DensePoly p) {
        DensePoly res = new DensePoly();
         Iterator<PolynomialTerms> it = this.term.iterator();
         Iterator<PolynomialTerms> it2 = p.term.iterator();
        return res;
    }

    /**
     * @return the largest exponent in this with non zero coeff or 0 if this
     * is the zero poly
     */
    public int degree() {
        assert (this.term != null);
        if (this.term.isEmpty()) {
            return (0);
        }
        int highest = 0;
        for (int i = 0; i < this.term.size(); i++) {
            PolynomialTerms cpe = this.term.first();
            if (cpe.exponent > highest) {
                highest = cpe.exponent;
            }
        }
        return (highest);
    }

    /**
     * @param n: an exponent.
     * @return the coefficient of the term in this that has exponent n; possibly 0
     */
    public int coeff(int n) {
        assert (this.term != null);
        Iterator<PolynomialTerms> it = this.term.iterator();
        while (it.hasNext()) {
            PolynomialTerms cpe = it.next();
            if (cpe.exponent == n) {
                return (cpe.coeff);
            }
        }
        return (0);
    }

    /**
     * @return the poly -(this)
     */
    public DensePoly minus() {
        DensePoly res = new DensePoly();
        for (int i = 0; i < term.size(); i++) {
            PolynomialTerms t = new PolynomialTerms((-term.first().coeff), term.first().exponent);
            res.term.add(t);
        }
        return res;
    }

    /**
     * @param p: the poly to be multiplied to this; REQUIRE not null.
     * @return a new poly that is this*p
     */

    public DensePoly mul(DensePoly p) {
        DensePoly res = new DensePoly();
        for (int i = 0; i < term.size(); i++) {
            res.term.add(term.first());
        }
        for (int i = 0; i < p.term.size(); i++) {
            PolynomialTerms t = new PolynomialTerms(res.term.first().coeff * p.term.first().coeff, res.term.first().exponent * p.term.first().exponent);
            res.term.add(t);
        }
        return res;
    }


    public String toString() {
        assert (this.term != null);
        StringBuffer s = new StringBuffer();
        Iterator<PolynomialTerms> it = this.term.iterator();
        while (it.hasNext()) {
            PolynomialTerms cpe = it.next();
            s.append(String.format("+%d*x^%d", cpe.coeff, cpe.exponent));
        }
        return (s.toString());
    }
}
