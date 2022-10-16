/*
    MEDIUM
    Determines whether or not possible task scheduling exists, where each vertex is a task and the edges are prerequisites
    as long as all vertices are connected, and no cycle exists then a possible schedule exists
 */

import java.util.*;

public class TaskScheduling {
    public static void main (String [] args) {
        int [] [] edges = new int[][] {{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {3,6}, {4,6}, {5,4}, {5,6}};
        boolean scheduleExists = sort (7, edges);
        System.out.println(scheduleExists);

        int [] [] edges2 = new int[][] {{0,1}, {0,2}, {1,3}, {3,1}, {1,4}, {2,5}, {3,6}, {4,6}, {5,4}, {5,6}};
        boolean scheduleExists2 = sort(8, edges2);
        System.out.println(scheduleExists2);
    }

    public static boolean sort (int size, int [] [] edges) {
        List <Integer> result = new ArrayList<>();                      // sorted list to return
        HashMap<Integer, Integer> inDegree = new HashMap<>();           // map of each vertex to it's in degree (number of incoming edges)
        HashMap<Integer, List<Integer>> graph = new HashMap<>();        // map of graph, each vertex is mapped to list of it's children

        for (int i = 0; i < size; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];               // parent is first element in 2D array
            int child = edges[i][1];                // child is second element in 2D array
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);       // only increasing in degree of second element (child) because it being a child means there is another incoming edge
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int tempVertex = sources.poll();
            result.add(tempVertex);
            List <Integer> tempVertexChildren = graph.get(tempVertex);
            for (int i = 0; i < tempVertexChildren.size(); i++) {
                inDegree.put(tempVertexChildren.get(i), inDegree.get(tempVertexChildren.get(i)) - 1);
                if (inDegree.get(tempVertexChildren.get(i)) == 0) {
                    sources.add(tempVertexChildren.get(i));
                }
            }
        }

        return result.size() == size;
    }
}
