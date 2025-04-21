package contest.weekly.c442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2 {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        UnionFind uf = new UnionFind(n);

        // Convert each row to a HashSet for quick intersection checks
        List<Set<Integer>> sets = new ArrayList<>();
        for (int[] row : properties) {
            Set<Integer> set = new HashSet<>();
            for (int num : row) {
                set.add(num);
            }
            sets.add(set);
        }

        // Compare all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(sets.get(i), sets.get(j)) >= k) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }

    // Count distinct common elements between two sets
    private int intersect(Set<Integer> a, Set<Integer> b) {
        int count = 0;
        for (int num : a) {
            if (b.contains(num)) {
                count++;
            }
        }
        return count;
    }

    // Union-Find Data Structure with Path Compression & Union by Rank
    static class UnionFind {
        private int[] parent, rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n; // Initially, each node is its own component
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--; // Reduce number of components
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        var sol = new Q2();
        var properties = new int[][] {
                { 1, 2, 3 },
                { 2, 3, 4 },
                { 4, 3, 5 }
        };

        var k = 1;
        System.out.println(sol.numberOfComponents(properties, k));
    }
}
