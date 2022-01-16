package medium;

import toolclass.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/1/16 9:41
 */
public class GetRandom382 {
    private List<Integer> arr=new ArrayList<Integer>();
    public GetRandom382(ListNode head){
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
    }
    public int getRandom(){
        int rand=(int)(Math.random()*arr.size());
        return arr.get(rand);
    }
}
