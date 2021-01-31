package hard;
//如果交换字符串X 中的两个不同位置的字母，使得它和字符串Y 相等，那么称 X 和 Y 两个字符串相似。
//        如果这两个字符串本身是相等的，那它们也是相似的。
//        例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)；"rats" 和 "arts" 也是相似的，
//        但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
//        总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，
//        "tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，
//        要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
//        给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。
//        请问 strs 中有多少个相似字符串组？

public class NumSimilarGroups839 {
    /**
     * 并查集的思想，按模板写并查集类
     * 单独写并查集类不如把并查集思想融入到函数里的速度快，比如把parent数组直接设置为函数里的一个数组
     * @param strs
     * @return
     */
    public int numSimilarGroups(String[] strs){
      int n=strs.length;
      UnionFind unifind=new UnionFind(n);
      for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
              if(simString(strs[i],strs[j])){
                unifind.Union(i,j);
              }
          }
      }
      return unifind.SetCount;
    }
    class UnionFind{
        int[] parent;
        int SetCount;
        public UnionFind(int n){
            parent=new int[n];
            SetCount=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int Find(int x){
            if(parent[x]!=x){
                parent[x]=Find(parent[x]);
            }
            return parent[x];
        }
        public void Union(int x,int y){
             x=Find(x);
             y=Find(y);
             if(x==y){
                 return;
             }
             parent[y]=x;
             SetCount--;
        }
    }
    public boolean simString(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        if(count==2||count==0){
            return true;
        }else {
            return false;
        }
    }
}
