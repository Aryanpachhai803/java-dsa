package Practical;

import java.util.*;
public class DijkstrasAlgo {
    static void dijkstra(int[][] graph, int source) {
        int n = graph.length;

        int[] dist = new int[n];       // stores shortest distance
        boolean[] visited = new boolean[n]; // tracks visited nodes

        // Initialize distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Loop for all vertices
        for (int i = 0; i < n - 1; i++) {

            // Find minimum distance vertex
            int min = Integer.MAX_VALUE, u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            visited[u] = true;
            // Update distances of neighbors
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 0, 5},
            {10, 0, 1, 2},
            {0, 1, 0, 4},
            {5, 2, 4, 0}
        };
        int source = 0;
        dijkstra(graph, source);
    }
}
