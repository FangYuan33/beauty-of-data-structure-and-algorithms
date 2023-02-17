package com.algorithms.graph;

import java.util.*;

/**
 * 邻接表实现无向图
 *
 * @author FangYuan
 * @since 2023-02-17 15:25:58
 */
public class GraphAdjacencyList {

    private final Map<Vertex, List<Vertex>> adjacencyList;

    /**
     * 构造邻接表无向图
     *
     * @param edges 顶点边关系 n行2列的二维数组
     */
    public GraphAdjacencyList(Vertex[][] edges) {
        adjacencyList = new HashMap<>();
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    public void addVertex(Vertex val) {
        if (adjacencyList.containsKey(val)) {
            return;
        }
        adjacencyList.put(val, new ArrayList<>());
    }

    public void removeVertex(Vertex val) {
        if (adjacencyList.containsKey(val)) {
            adjacencyList.remove(val);
            for (List<Vertex> edges : adjacencyList.values()) {
                edges.remove(val);
            }
        }
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).remove(vertex2);
            adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    public void print() {
        System.out.println("邻接表 =");
        for (Map.Entry<Vertex, List<Vertex>> entry : adjacencyList.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : entry.getValue())
                tmp.add(vertex.getVal());
            System.out.println(entry.getKey().getVal() + ": " + tmp + ",");
        }
    }
}

class Vertex {

    public static Vertex[] valsToVets(int[] vals) {
        Vertex[] vets = new Vertex[vals.length];
        for (int i = 0; i < vals.length; i++) {
            vets[i] = new Vertex(vals[i]);
        }
        return vets;
    }

    private int val;

    public Vertex(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}

class TestGraphAdjacencyList {
    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[]{1, 3, 2, 5, 4});
        Vertex[][] edges = {{v[0], v[1]}, {v[0], v[3]}, {v[1], v[2]}, {v[2], v[3]}, {v[2], v[4]}, {v[3], v[4]}};
        GraphAdjacencyList graph = new GraphAdjacencyList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 即 v[0], v[2]
        graph.addEdge(v[0], v[2]);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 即 v[0], v[1]
        graph.removeEdge(v[0], v[1]);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        Vertex v5 = new Vertex(6);
        graph.addVertex(v5);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 即 v[1]
        graph.removeVertex(v[1]);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }
}
