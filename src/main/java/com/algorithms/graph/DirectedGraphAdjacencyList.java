package com.algorithms.graph;

import java.util.*;

/**
 * 邻接表实现有向图
 *
 * @author FangYuan
 * @since 2023-02-17 22:02:21
 */
public class DirectedGraphAdjacencyList {
    private final Map<Vertex, List<Vertex>> adjacencyList;

    /**
     * 构造邻接表有向图
     *
     * @param edges 顶点边关系 n行2列的二维数组
     */
    public DirectedGraphAdjacencyList(Vertex[][] edges) {
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

    /**
     * 相比于无向图，两顶点分先后顺序，此参数表示前者依赖后者
     */
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).add(vertex2);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).remove(vertex2);
        }
    }

    /**
     * Kahn实现拓扑排序
     * 规定如果A依赖B的话，那么添加A指向B的边，A的出度为1，当出度为0时将其输出到结果序列中
     */
    public void topoSortByKahn() {
        List<Integer> res = new ArrayList<>(adjacencyList.size());
        Queue<Vertex> queue = new LinkedList<>();

        // 保存出度为0的顶点
        queue0OutDegree(queue);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            res.add(vertex.getVal());

            // 移除这个点，再记录出度为0的点
            removeVertex(vertex);
            queue0OutDegree(queue);
        }

        System.out.println(res);
    }

    /**
     * 出度为0的顶点入队
     */
    private void queue0OutDegree(Queue<Vertex> queue) {
        for (Map.Entry<Vertex, List<Vertex>> vertexListEntry : adjacencyList.entrySet()) {
            if (vertexListEntry.getValue().isEmpty()) {
                queue.offer(vertexListEntry.getKey());
            }
        }
    }
}

class TestDirectedGraphAdjacencyList {
    public static void main(String[] args) {
        Vertex[] v = Vertex.valsToVets(new int[]{1, 3, 2, 5, 4});
        Vertex[][] edges = {{v[0], v[1]}, {v[1], v[2]}, {v[2], v[3]}, {v[3], v[4]}, {v[1], v[3]}, {v[0], v[4]}};

        DirectedGraphAdjacencyList directedGraph = new DirectedGraphAdjacencyList(edges);
        directedGraph.topoSortByKahn();
    }
}
