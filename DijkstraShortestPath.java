

import java.util.*;

class Edge {
    int target;
    int weight;

    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class DijkstraShortestPath {

    public static void dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[source] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a]));
        pq.add(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Shortest distance to node " + i + " = " + dist[i]);
            System.out.print(" | Path: ");
            printPath(parent, i);
            System.out.println();
        }
    }

    private static void printPath(int[] parent, int node) {
        if (node == -1) return;
        printPath(parent, parent[node]);
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        int n = 5; 
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        int source = 0;
        dijkstra(graph, source);
    }
}
