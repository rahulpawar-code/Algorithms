class WeightedUnionFind {
    int[] id;
    int[] size;

    public WeightedUnionFind(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < id.length; ++i) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int pid = root(p);
        int qid = root(q);
        if (pid == qid) {
            return;
        }
        if (size[p] > size[q]) {
            id[pid] = qid;
            size[pid] += size[qid];
        } else {
            id[qid] = pid;
            size[qid] += size[pid];
        }
    }

    public static void main(String[] args) {
        WeightedUnionFind set = new WeightedUnionFind(10);
        set.union(4, 3);
        set.union(3, 8);
        set.union(6, 5);
        set.union(9, 4);
        System.out.println(set.connected(3, 9));
        set.union(2, 1);
        set.union(8, 9);
        System.out.println(set.connected(1, 0));
        set.union(5, 0);
        set.union(7, 2);
        set.union(6, 1);
        set.union(1, 0);
        set.union(6, 7);
        System.out.println(set.connected(9, 7));
    }
}
