package medium;
//通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10)=10*9*8*7*6*5*4*3*2*1。
//        相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，
//        加法(+)和减法(-)。
//        例如，clumsy(10)=10*9/8+7-6*5/4+3-2*1。然而，这些运算仍然使用通常的算术运算顺序:
//        我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
//        另外，我们使用的除法是地板除法（floor division），所以10*9/8等于11。这保证结果是一个整数。
//        实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wy
 * @date 2021/4/1 8:36
 */
public class Clumsy1006 {
    public int clumsy(int N){
        Deque<Integer> stack=new ArrayDeque<Integer>();
        int k=0;
        stack.push(N);
        for(int i=N-1;i>0;i--){
            if(k==0){
                stack.push(stack.pop()*i);
            }
            if(k==1){
                stack.push(stack.pop()/i);
            }
            if(k==2||k==3){
                stack.push(i);
            }
            k=(k+1)%4;
        }
        Deque<Integer> st=new ArrayDeque<Integer>();
        while(!stack.isEmpty()){
            st.push(stack.peek());
            stack.pop();
        }
        k=0;
        int res=st.peek();
        st.pop();
        while(!st.isEmpty()){
            if(k==0){
                res+=st.peek();
                st.pop();
            }
            if(k==1){
                res-=st.peek();
                st.pop();
            }
            k=(k+1)%2;
        }
        return res;
    }

    /**
     * 把减号变成负值，这样直接求和就可以了，就不用再开辟一个栈了
     * @param N
     * @return
     */
    public int clumsy2(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        int index = 0; // 用于控制乘、除、加、减
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
    /**
     * 数学公式推导法
     * @param N
     * @return
     */
    public int clumsy1(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }
}
