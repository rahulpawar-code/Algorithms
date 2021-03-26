class QuickFind {
    int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; ++i) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int get(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; ++i) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFind set = new QuickFind(10);
        set.union(4, 3);
        set.union(3, 8);
        set.union(6, 5);
        set.union(9, 4);
        System.out.println(set.connected(3, 9));
        System.out.println(set.get(8));
        set.union(2, 1);
        set.union(8, 9);
        System.out.println(set.connected(1, 0));
        System.out.println(set.get(0));
        set.union(5, 0);
    }
}


