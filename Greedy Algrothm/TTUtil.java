package com.java.ga;

import java.util.List;

public class TTUtil {

    private final int dataLen;
    private final int codeLen;

    public TTUtil(int dataLen, int codeLen) {
        this.dataLen = dataLen;
        this.codeLen = codeLen;
    }

    public int getDataLen() {
        return dataLen;
    }

    public int getCodeLen() {
        return codeLen;
    }

    /**
     * Count the Cost of a Given Encoding Scheme
     *
     * @param method Coding Scheme
     * @return Number of State Transitions
     */
    Transition methodTransition(List<Integer> method) {
        Transition total = new Transition();
        int codeSize = 1 << codeLen;
        int dataSize = 1 << dataLen;
        int groupSize = 1 << (codeLen - dataLen);
        for (int i = 0; i < codeSize; i++) {
            for (int j = 0; j < dataSize; j++) {
                if (j == i / groupSize) {
                    continue;
                }
                Transition t = new Transition();
                selectCode(method.get(i), j, method, t);
                total.plus(t);
            }
        }
        return total;
    }

    /**
     * Select the Optimal Target Encoding
     *
     * @param from       Current Data Encoding
     * @param method     All Optional Encodings to Which the Target Data is Mapped
     * @param transition Used to Receive the Calculated State Transition Count Results
     * @return The Subscript of the Optimal Target Encoding in Codes
     */
    public int selectCode(int from, int to, List<Integer> method, Transition transition) {
        int groupSize = 1 << (codeLen - dataLen);
        int start = to * groupSize;
        int end = start + groupSize;
        Transition minTrans = Transition.count(from, method.get(start), codeLen);
        int min = 0;

        for (int i = start; i < end; i++) {
            Transition t = Transition.count(from, method.get(i), codeLen);
            if (t.tt < minTrans.tt || t.tt == minTrans.tt && t.cost() < minTrans.cost()) {
                minTrans = t;
                min = i;
            }
        }

        if (transition != null) {
            transition.set(minTrans);
        }

        return min;
    }
}
