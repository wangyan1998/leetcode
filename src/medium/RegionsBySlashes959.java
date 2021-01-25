package medium;
//在由 1 x 1 方格组成的 N x N 网格grid 中，每个 1 x 1方块由 /、\ 或空格构成。
//        这些字符会将方块划分为一些共边的区域。
//        （请注意，反斜杠字符是转义的，因此 \ 用 "\\"表示。）。
//        返回区域的数目。


import java.util.HashSet;
import java.util.Set;

public class RegionsBySlashes959 {
    /**
     * 并查集：
     * 把每个小方格的两条对角线分成四个三角，每个三角形当成一个节点，通过看对角线的存在情况
     * 将三角形连通，求最后连通分量的个数。
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid){
      int n=grid.length;
      int[] f=new int[n*n*4];
      for(int i=0;i<f.length;i++){
          f[i]=i;
      }
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              int idx=i*n+j;
              if(i<n-1){
                  int bottom=idx+n;
                  merge(f,idx*4+2,bottom*4);
              }
              if(j<n-1){
                  int right=idx+1;
                  merge(f,idx*4+1,right*4+3);
              }
              if(grid[i].charAt(j)=='/'){
                  merge(f,idx*4,idx*4+3);
                  merge(f,idx*4+1,idx*4+2);
              }else if(grid[i].charAt(j)=='\\'){
                  merge(f,idx*4,idx*4+1);
                  merge(f,idx*4+2,idx*4+3);
              }else {
                  merge(f,idx*4,idx*4+1);
                  merge(f,idx*4+1,idx*4+2);
                  merge(f,idx*4+2,idx*4+3);
              }
          }
      }
        Set<Integer> fathers=new HashSet<Integer>();
      for(int i=0;i<n*n*4;i++){
          int fa=find(f,i);
          fathers.add(fa);
      }
      return fathers.size();
    }
    public int find(int[] f,int x){
        if(f[x]==x){
            return x;
        }
        int fa=find(f,f[x]);
        f[x]=fa;
        return fa;
    }
    public void merge(int[] f,int x,int y){
        int fx=find(f,x);
        int fy=find(f,y);
        f[fx]=fy;
    }
}
