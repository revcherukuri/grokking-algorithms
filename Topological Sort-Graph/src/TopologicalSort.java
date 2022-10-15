/*
    MEDIUM
    Returns Topologically sorted list of directed acyclic graph
 */

import java.util.*;

public class TopologicalSort {
    public static void main (String [] args) {
        int [] [] edges = new int[][] {{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {3,6}, {4,6}, {5,4}, {5,6}};
        List <Integer> topSorted = sort (7, edges);
        System.out.println(topSorted);
    }

    public static List<Integer> sort (int size, int [] [] edges) {
        List <Integer> result = new ArrayList<>();                      // sorted list to return
        HashMap<Integer, Integer> inDegree = new HashMap<>();           // map of each vertex to it's in degree (number of incoming edges)
        HashMap<Integer, List<Integer>> graph = new HashMap<>();        // map of graph, each vertex is mapped to list of it's children

        /**
         * First step
         * initialize inDegree map with all vertices and in degree values of 0.
         * initialize graph map with all vertices and empty list for children
         */
        for (int i = 0; i < size; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        /**
         * Second step (build graph)
         * add children to parent's list in graph map
         * update children in degrees
         */
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];               // parent is first element in 2D array
            int child = edges[i][1];                // child is second element in 2D array
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);       // only increasing in degree of second element (child) because it being a child means there is another incoming edge
        }

        /**
         * Third step (find sources -> no in degree)
         * loop through inDegree map and add all sources to queue
         */
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        /**
         * Fourth step (add sources to results, remove them from graph, update new sources after removal)
         * BFS -> uses queue and go one level of sources at a time until it is empty (meaning all vertices have been touched)
         * get source from queue, add it to results, loop through its children, decrement all their in degrees because parent is being removed. Add any children with new in degrees of 0 to sources queue
         */
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

        /**
         * Fifth step (check if cycle exists)
         */
        if (result.size() != size) {
            return new ArrayList<>();
        }

        return result;
    }
}
