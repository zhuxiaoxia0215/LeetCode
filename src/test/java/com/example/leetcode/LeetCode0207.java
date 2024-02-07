package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode0207 {

    List<List<Integer>> edges;
    int[] isVisited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        isVisited = new int[numCourses];
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (isVisited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        isVisited[u] = 1;
        List<Integer> list = edges.get(u);
        for (Integer v : list) {
            if (isVisited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (isVisited[v] == 1) {
                valid = false;
                return;
            }
        }
        isVisited[u] = 2;
    }
}
