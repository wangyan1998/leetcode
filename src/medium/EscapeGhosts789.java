package medium;
//你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是target = [xtarget, ytarget] 。
//        地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从ghosts[i] = [xi, yi]出发。所有输入均为 整数坐标 。
//        每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。
//        当然，也可以选择 不动 。所有动作 同时 发生。
//        如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。
//        如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
//        只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。


/**
 * @author wy
 * @date 2021/8/22 9:35
 */
public class EscapeGhosts789 {
    /**
     * 用dist(A,B) 表示 AA 点和 BB 点的曼哈顿距离，曼哈顿距离的计算方法如下：
     * dist(A,B)=|x1-x2|+|y1-y2|
     * 如果有一个阻碍者和目的地的曼哈顿距离小于玩家和目的地的曼哈顿距离，则该阻碍者可以在玩家之前到达目的地，然后停在目的地，玩家无法逃脱。
     * 如果有一个阻碍者和目的地的曼哈顿距离等于玩家和目的地的曼哈顿距离，则该阻碍者可以和玩家同时到达目的地，玩家也无法逃脱。
     * 如果所有的阻碍者和目的地的曼哈顿距离都大于玩家和目的地的曼哈顿距离，则玩家可以在阻碍者之前到达目的地。
     * 如果玩家可以在阻碍者之前到达目的地，是否可能出现阻碍者在玩家前往目的地的中途拦截？答案是否定的
     * @param ghosts
     * @param target
     * @return
     */
    public boolean escapeGhosts(int[][] ghosts,int[] target){
      int[] source={0,0};
      int distance=manhattanDistance(source,target);
      for(int[] ghost:ghosts){
          int ghostDistance=manhattanDistance(ghost,target);
          if(ghostDistance<=distance){
              return false;
          }
      }
      return true;
    }
    public int manhattanDistance(int[] point1,int[] point2){
        return Math.abs(point1[0]-point2[0])+Math.abs(point1[1]-point2[1]);
    }
}
