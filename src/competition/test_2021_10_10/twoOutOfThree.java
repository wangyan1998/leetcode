package competition.test_2021_10_10;
//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个不同数组，且由至少在两个数组中出现的所有值组成。数组中的元素可以按任意顺序排列。
import java.util.*;

/**
 * @author wy
 * @date 2021/10/10 10:30
 */
public class twoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1=new HashSet<Integer>();
        Set<Integer> set2=new HashSet<Integer>();
        List<Integer> res=new ArrayList<Integer>();
        for (int num1:nums1){
            set1.add(num1);
        }
        for(int num2:nums2){
            if(set1.contains(nums2)&&!res.contains(num2)){
                res.add(num2);
            }else {
                set2.add(num2);
            }
        }
        for(int num3:nums3){
            if((set1.contains(num3)||set2.contains(num3))&&!res.contains(num3)){
                res.add(num3);
            }
        }
        return res;
    }
}
