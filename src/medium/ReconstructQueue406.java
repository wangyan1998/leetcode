package medium;
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
//编写一个算法来重建这个队列。
//        注意：
//        总人数少于1100人。
//        示例
//        输入:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//        输出:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

import java.util.*;

public class ReconstructQueue406 {
    //先把数组按照身高从小到大排序，然后再确定位置，第i人的位置应该保证前面有k个位置放身高大于i的人
    //因为从小到大排序，所以已经排好的i之前的人都比i矮，所以已经排好的人不影响i的位置，只需要在放置i的时候在前面留够空位置就可以了
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0]!=person2[0]){
                    return person1[0]-person2[0];
                }else {
                    return person2[1]-person1[1];
                }
            }
        });
        int n=people.length;
        int[][] ans=new int[n][];
        for(int[] person:people){
            int spaces=person[1]+1;
            for(int i=0;i<n;++i){
                if(ans[i]==null){
                    --spaces;
                    if(spaces==0){
                        ans[i]=person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    //把数组按身高从大到小，k从小到大排列。这样只需要插空就可以了，因为后面的人都比他矮，无论怎么插都不会对当前人造成影响
    public int[][] reconstructQueue1(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0]!=person2[0]){
                    return person2[0]-person1[0];
                }else {
                    return person1[1]-person2[1];
                }
            }
        });
        List<int[]> ans=new ArrayList<int[]>();
        for(int[] person:people){
            ans.add(person[1],person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
