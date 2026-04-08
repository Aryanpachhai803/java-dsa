package Practical;

import java.util.*;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}
public class KruskalsAlgo {

    static int[] parent;

    // Find parent of a node
    static int find(int node) {
        if (parent[node] == node)
            return node;
        return find(parent[node]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        edges.sort((a, b) -> a.weight - b.weight);

        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;

        System.out.println("Edges in MST:");

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) { // no cycle
                union(e.u, e.v);
                System.out.println(e.u + " - " + e.v + " : " + e.weight);
                totalWeight += e.weight;
            }
        }
        System.out.println("Total weight: " + totalWeight);
    }
}