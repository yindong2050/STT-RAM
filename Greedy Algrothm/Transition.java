package com.java.ga;

public class Transition {
    int zt, st, ht, tt;

    public Transition() {
        this(0, 0, 0, 0);
    }

    public Transition(int zt, int st, int ht, int tt) {
        this.zt = zt;
        this.st = st;
        this.ht = ht;
        this.tt = tt;
    }

    public void set(int zt, int st, int ht, int tt) {
        this.zt = zt;
        this.st = st;
        this.ht = ht;
        this.tt = tt;
    }

    public void set(Transition transition) {
        set(transition.zt, transition.st, transition.ht, transition.tt);
    }

    public void plus(Transition transition) {
        set(zt + transition.zt, st + transition.st, ht + transition.ht, tt + transition.tt);
    }

    /**
     * Calculate the Energy Cost Corresponding to a Given Number of State Transitions
     *
     * @return Energy Consumption
     */
    public long cost() {
        return st * 843L + ht * 1659L + tt * 2502L;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "zt=" + zt +
                ", st=" + st +
                ", ht=" + ht +
                ", tt=" + tt +
                ", cost=" + cost() / 1000.0
                + '}';
    }

    /**
     * Count the Number of State Transitions
     *
     * @param from Current Data Encoding
     * @param to   Target Data Encoding
     * @return Number of State Transitions
     */
    public static Transition count(int from, int to, int codeLen) {
        Transition res = new Transition();
        int a = from, b = to;
        // Compare Two Bits at a time
        for (int i = 0; i < codeLen; i += 2) {
            int x = a & 0b11;
            int y = b & 0b11;
            if (x == y) {
                res.zt++;
            } else if ((x == 0b00 && y == 0b01) || (x == 0b01 && y == 0b00) ||
                    (x == 0b10 && y == 0b11) || (x == 0b11 && y == 0b10)) {
                res.st++;
            } else if ((x == 0b00 && y == 0b11) || (x == 0b11 && y == 0b00) ||
                    (x == 0b01 && y == 0b11) || (x == 0b10 && y == 0b00)) {
                res.ht++;
            } else {
                res.tt++;
            }
            a >>= 2;
            b >>= 2;
        }
        return res;
    }
}
