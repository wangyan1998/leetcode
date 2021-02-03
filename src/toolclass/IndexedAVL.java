package toolclass;

public class IndexedAVL {
    private static class Node{
        // 节点存储的真实的数据
        int val;
        // size 是这节点统辖的树的所有元素的总个数，
        // cnt这个节点存储val出现的次数, height是节点的高度
        int size,cnt,height;
        Node left,right;

        public Node(int val) {
            this.val = val;
            this.cnt = this.height = this.size = 1;
        }
    }

    private int size;

    public int getSize() {
        return size;
    }

    private Node root;

    private int h(Node node){
        return node==null?0:node.height;
    }

    private int getSize(Node p){
        return p==null?0:p.size;
    }

    private void pushUp(Node p){
        p.height = Math.max(h(p.left),h(p.right))+1;
        p.size = p.cnt + getSize(p.left) + getSize(p.right);
    }

    // 右旋
    private Node zig(Node p){
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        pushUp(p);
        pushUp(q);
        return q;
    }

    // 左旋
    private Node zag(Node q){
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        pushUp(q);
        pushUp(p);
        return p;
    }

    private Node LL(Node t){
        return zig(t);
    }

    private Node LR(Node t){
        t.left = zag(t.left);
        return zig(t);
    }

    private Node RR(Node t){
        return zag(t);
    }

    private Node RL(Node t){
        t.right = zig(t.right);
        return zag(t);
    }

    private Node insert(Node t,int value) {
        if(t == null){
            return new Node(value);
        }

        Node newRoot = t;

        // 插入完成之后，要将搜索路径上的点依次进行调整 height,调整 size的大小

        if(value < t.val){
            t.left =  insert(t.left,value);

            int leftH = h(t.left);
            int rightH = h(t.right);

            if(leftH - rightH > 1){
                // LL型
                if(value <= t.left.val){
                    newRoot =  LL(t);
                    // LR型
                }else{
                    newRoot =  LR(t);
                }
            }

        }else if(value > t.val){
            t.right =  insert(t.right,value);

            int leftH = h(t.left);
            int rightH = h(t.right);

            if(rightH -leftH >1){
                // RR型
                if(value >= t.right.val){
                    newRoot = RR(t);
                    // RL型
                }else{
                    newRoot = RL(t);
                }
            }

        }else {
            t.cnt++;
        }
        pushUp(newRoot);
        return newRoot;
    }

    private Node remove(Node t,int value) {
        if(t == null) return null;

        Node newRoot = t;

        if(value < t.val){

            t.left = remove(t.left,value);
            // 删除左子树的节点，唯一可能导致"失衡" 的情况是 bf由 -1 变成-2
            int leftH = h(t.left);
            int rightH = h(t.right);

            if(rightH - leftH > 1){
                if( h(t.right.right) >= h(t.right.left) ){
                    newRoot = RR(t);
                }else{
                    newRoot = RL(t);
                }
            }

        } else if(value > t.val){

            t.right = remove(t.right,value);
            int leftH = h(t.left);
            int rightH = h(t.right);
            // 删除右子树的节点，唯一可能导致"失衡" 的情况是 bf由 1 变成 2
            if(leftH - rightH > 1){
                if(h(t.left.left) >= h(t.left.right)){
                    newRoot = LL(t);
                }else{
                    newRoot = LR(t);
                }
            }
        }else{

            if(t.cnt>1){
                t.cnt--;
            }else{
                // 下面细分成 3种情况 (左右子树都为空，一棵为空另一棵不为空，都不为空)
                if(t.left == null && t.right == null){

                    return null;
                }else if(t.left != null && t.right == null){
                    return t.left;
                }else if(t.left == null){
                    return t.right;
                }else{
                    // 用前驱的值代替（后继也是一样）
                    Node cur = t.left;
                    while(cur.right != null){
                        cur = cur.right;
                    }
                    t.val = cur.val;
                    t.left = remove(t.left,cur.val);
                    // 这个地方仍然要有形态的调整
                    // 删除左子树的节点，唯一可能导致"失衡" 的情况是 bf由 -1 变成-2
                    int leftH = h(t.left);
                    int rightH = h(t.right);

                    if(rightH - leftH > 1){
                        if( h(t.right.right) >= h(t.right.left) ){
                            newRoot = RR(t);
                        }else{
                            newRoot = RL(t);
                        }
                    }
                }
            }

        }
        pushUp(newRoot);
        return newRoot;
    }

    private int getItemByRank(Node node,int rank){
        if(node == null) return Integer.MIN_VALUE;
        if(getSize(node.left) >= rank) return getItemByRank(node.left,rank);
        if(getSize(node.left)+node.cnt >= rank) return node.val;
        return getItemByRank(node.right,rank-getSize(node.left)-node.cnt);
    }

    public int getItemByRank(int rank){
        return getItemByRank(root,rank);
    }

    public void add(int value){
        root = insert(root,value);
        this.size++;
    }

    public void erase(int value){
        root = remove(root,value);
        this.size--;
    }

}
