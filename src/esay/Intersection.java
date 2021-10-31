package esay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定两个数组，编写一个函数来计算它们的交集
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
public class Intersection {
    public int[] intersection(int[] nums1,int[] nums2){//遍历，使用工具Set，因为Set不包含重复元素
        int n1=nums1.length;
        int n2=nums2.length;
        Set<Integer> res=new HashSet<Integer>();
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums1[i]==nums2[j]){
                     res.add(nums1[i]);
                }
            }
        }
        Integer[] r=res.toArray(new Integer[]{});//Set转成int数组
        int[] r1=new int[r.length];
        for(int i=0;i<r.length;i++){
            r1[i]=r[i].intValue();
        }
       return r1;
    }
    public int[] intersection1(int[] nums1,int[] nums2){//排序+双指针
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1=nums1.length,length2=nums2.length;
        int[] intersection=new int[length1+length2];
        int index=0,index1=0,index2=0;
        while(index1<length1&&index2<length2){
            int num1=nums1[index1],num2=nums2[index2];
            if(num1==num2){
                //保证元素的唯一性
                if(index==0||num1!=intersection[index-1]){
                    intersection[index++]=num1;
                }
                index1++;
                index2++;
            }else if(num1<num2){
                index1++;
            }else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
}
