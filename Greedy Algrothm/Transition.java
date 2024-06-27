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
     * 计算给定状态转换次数对应的能量开销
     *
     * @return 能量开销
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
     * 统计从 from 改写为 to 的状态转换次数
     *
     * @param from 当前数据编码
     * @param to   目标数据编码
     * @return 状态转换次数
     */
    public static Transition count(int from, int to, int codeLen) {
        Transition res = new Transition();
        int a = from, b = to;
        // 每次比较两位
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
