package leetcode.medium;

import java.util.*;

public class LeetCode6139 {


    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graphEdge = (List<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graphEdge[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graphEdge[from].add(to);
            graphEdge[to].add(from);
        }
        System.out.println(Arrays.toString(graphEdge));
        // 构建完边了
        Queue<Integer> forPath = new ArrayDeque<>();
        int result = 1;
        boolean[] mark = new boolean[n];
        mark[0] = true;
        forPath.add(0);
        while (!forPath.isEmpty()) {
            Integer next = forPath.poll();
            for (Integer m : graphEdge[next]) {
                if (!mark[m]) {
                    mark[m] = true;
                    if (!isInRestricted(restricted, m)) {
                        result++;
                        forPath.add(m);
                    }
                }
            }

        }
        return result;
    }

    private boolean isInRestricted(int[] restricted, int node) {
        for (int i = 0; i < restricted.length; i++) {
            if (restricted[i] == node) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6139().reachableNodes(10, new int[][]
                        {{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}},
                new int[]{2, 7}));
    }
}