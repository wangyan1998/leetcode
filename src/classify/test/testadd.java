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
    public int a=4;
    public int getnum(){
        return 0;
    }
    public static void main(String[] args) {
       ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        ClassLoader parent=classLoader.getParent();
        System.out.println(parent);
        ClassLoader c=parent.getParent();
        System.out.println(c);
        System.out.println(testadd.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(testadd.class.getMethods());
    }
}
