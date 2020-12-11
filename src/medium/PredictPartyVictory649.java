package medium;
//Dota2 的世界里有两个阵营：Radiant(天辉)和Dire(夜魇)
//        Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。
//        在每一轮中，每一位参议员都可以行使两项权利中的一项：
//        (1).禁止一名参议员的权利：
//          参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
//        (2).宣布胜利：
//          如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
//        给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了Radiant（天辉）和Dire（夜魇）。
//        然后，如果有 n 个参议员，给定字符串的大小将是n。
//        以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。
//        所有失去权利的参议员将在过程中被跳过。
//        假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。
//        输出应该是Radiant或Dire。

import java.util.LinkedList;
import java.util.Queue;

public class PredictPartyVictory649 {
    /*
    假设当前是R在投，他可以做两件事，一是如果目前所有的议员全是R，则直接宣布胜利。二如果仍然有D的议员，应该贪心的挑选案投票顺序的
    下一名D议员，应该挑选最早可以投票的其他党派议员。因为总是要挑选投票顺序最早的议员。我们可以使用两个队列radiant和dire分别按
    投票顺序存储两派议员的投票时间。然后我们就可以开始该过程：
    （1）如果此时radiant和dire为空，那么就可以宣布另一方获胜；
    （2）如果都不空，比较两个队列的首元素，哪个比较小就说明该谁投票了，该议员会挑选另一个队列的首元素将其永久弹出，并将自己弹出，增加
    n后再重新放回队列。n是给定字符串的长度。
     */
    public String predictPartyVictory(String senate){
        int n=senate.length();
        Queue<Integer> radiant=new LinkedList<Integer>();
        Queue<Integer> dire=new LinkedList<Integer>();
        for(int i=0;i<n;++i){
            if(senate.charAt(i)=='R'){
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty()&&!dire.isEmpty()){
            int radiantIndex=radiant.poll(),direIndex=dire.poll();
            if(radiantIndex<direIndex){
                radiant.offer(radiantIndex+n);
            }else {
                dire.offer(direIndex+n);
            }
        }
        return !radiant.isEmpty()?"Radiant":"Dire";
    }
}
