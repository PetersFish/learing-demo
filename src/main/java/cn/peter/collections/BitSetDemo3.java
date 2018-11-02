package cn.peter.collections;

import java.util.BitSet;

/**
 * @author Peter Yu 2018/10/16 11:30
 */
public class BitSetDemo3 {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();

        int from = 19;
        int size = 18;
        bitSet.set(from, from+size);
        System.out.println(bitSet);
    }
}
