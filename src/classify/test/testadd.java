package classify.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wy
 * @date 2021/3/28 10:19
 */
public class testadd {
    public static void main(String[] args) {
        Set<List<Integer>> res=new HashSet<List<Integer>>();
        List<Integer> a=new ArrayList<Integer>();
        List<Integer> b=new ArrayList<Integer>();
       // a.add(2);
        b.add(2);
        res.add(a);
        res.add(b);
        System.out.println(res);
        System.out.println(res.size());
    }
}
