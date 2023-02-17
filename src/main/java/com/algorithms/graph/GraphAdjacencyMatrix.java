package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向图的邻接矩阵实现
 *
 * @author FangYuan
 * @since 2023-02-17 10:55:20
 */
public class GraphAdjacencyMatrix {

    // 顶点列表，保存顶点索引和顶点值
    private final List<Integer> vertices;
    // 邻接矩阵，行列索引对应顶点索引
    private final List<List<Integer>> adjacencyMatrix;

    /**
     * 构建无向图
     *
     * @param vertices 顶点值
     * @param edges    顶点的边关系 eg: {{ 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 4 }}
     */
    public GraphAdjacencyMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>(vertices.length);
        this.adjacencyMatrix = new ArrayList<>(vertices.length);

        // 初始化顶点值
        for (int vertex : vertices) {
            addVertex(vertex);
        }
        // 初始化邻接矩阵的边关系
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    /**
     * 新增顶点
     */
    public void addVertex(int val) {
        int n = vertices.size();
        vertices.add(val);
        // 初始化新增的行
        ArrayList<Integer> newRow = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }
        // 初始化新增的列
        adjacencyMatrix.add(newRow);
        for (List<Integer> row : adjacencyMatrix) {
            row.add(0);
        }
    }

    /**
     * 删除顶点
     *
     * @param index 顶点索引
     */
    public void removeVertex(int index) {
        if (index >= size()) {
            throw new RuntimeException("Out Of Bounds!");
        }
        vertices.remove(index);
        adjacencyMatrix.remove(index);
        for (List<Integer> row : adjacencyMatrix) {
            row.remove(index);
        }
    }

    public void addEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new RuntimeException("Out Of Bounds!");
        }

        adjacencyMatrix.get(i).set(j, 1);
        adjacencyMatrix.get(j).set(i, 1);
    }

    public void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new RuntimeException("Out Of Bounds!");
        }

        adjacencyMatrix.get(i).set(j, 0);
        adjacencyMatrix.get(j).set(i, 0);
    }

    public int size() {
        return vertices.size();
    }

    public void print() {
        System.out.print("顶点列表 = ");
        System.out.println(vertices);
        System.out.println("邻接矩阵 =");
        System.out.println("[");
        for (List<Integer> row : adjacencyMatrix) {
            System.out.println("  " + row + ",");
        }
        System.out.println("]");
    }
}
