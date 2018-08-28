package cn.peter.collections;

import java.util.BitSet;
import java.util.HashSet;

/**
 * @author Peter Yu
 * @date 2018/6/25 11:58
 */
public class BitSetDemo2 {

    public static void main(String[] args) {
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();

        // set some bits
        bits1.set(1,6);
        bits2.set(4,7);
        bits1.andNot(bits2);
        System.out.println(bits1);

    }

    private static boolean overlap(BitSet orginBranch, BitSet bitSet) {
        if(orginBranch.intersects(bitSet)){
            if(!(include(orginBranch, bitSet)||include(bitSet, orginBranch))){
                return true;
            }
        }
        return false;
    }

    private static boolean include(BitSet range, BitSet target) {
        BitSet tempSet = new BitSet();
        tempSet.or(range);
        tempSet.and(target);
        return tempSet.equals(target);
    }
}
