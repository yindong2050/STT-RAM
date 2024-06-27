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
     * 统计给定编码方案的开销
     *
     * @param method 编码方案
     * @return 状态转换次数
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
     * 选择最优的目标编码
     *
     * @param from       当前数据编码
     * @param method     目标数据映射到的所有可选的编码
     * @param transition 用于接收计算的状态转换次数结果
     * @return 最优的目标编码在codes中的下标
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
