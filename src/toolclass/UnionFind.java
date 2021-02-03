package toolclass;

public class UnionFind {
    int[] parent;
    int countSet;
    public UnionFind(int n){
        parent=new int[n];
        countSet=n;
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
    }
    public boolean isConnected(int x,int y){
        return Find(x)==Find(y);
    }
}
