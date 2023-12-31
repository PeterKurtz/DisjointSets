public class DisjointSet {
    private int[] set;

    public DisjointSet(int size) {
        set = new int[size];
        for (int i = 0; i < size; i++){
            set[i] = -1;
        }
    }

    public int find(int node) {
        if (set[node] < 0) {
            return node;
        }

        int root = find(set[node]);
        set[node] = root;
        return root;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        else if (set[root2] < set[root1]) {
            set[root2] += set[root1];
            set[root1] = root2;
        }

        else if (set[root1] <= set[root2]){
            set[root1] += set[root2];
            set[root2] = root1;
        }

    }
}
