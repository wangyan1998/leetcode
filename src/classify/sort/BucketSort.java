package classify.sort;

import java.util.ArrayList;

public class BucketSort {
    /**
    桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
    桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
    每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序。
    （1）人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，
        该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
    （2）遍历输入数据，并且把数据一个一个放到对应的桶里去；
    （3）对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
    （4）从不是空的桶里把排好序的数据拼接起来。
    注意，如果递归使用桶排序为各个桶排序，则当桶数量为1时要手动减小BucketSize增加下一循环桶的数量，
         否则会陷入死循环，导致内存溢出。
     */
    public ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {//如果待排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for(int j=0;j<temp.size();j++){
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }
}

