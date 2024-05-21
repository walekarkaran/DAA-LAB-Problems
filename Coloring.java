import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GraphColoring {
    private int numVertices;
    private List<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public GraphColoring(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList[u].add(v);
        adjacencyList[v].add(u);
    }

    public void greedyColoring() {
        int[] result = new int[numVertices];
        Arrays.fill(result, -1);
        
        // Assign the first color to the first vertex
        result[0] = 0;

        // A temporary array to store the available colors. False value
        // of available[cr] would mean that the color cr is assigned to
        // one of its adjacent vertices
        boolean[] available = new boolean[numVertices];
        Arrays.fill(available, true);

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < numVertices; u++) {
            // Process all adjacent vertices and flag their colors
            // as unavailable
            for (int adj : adjacencyList[u]) {
                if (result[adj] != -1) {
                    available[result[adj]] = false;
                }
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < numVertices; cr++) {
                if (available[cr]) {
                    break;
                }
            }

            result[u] = cr; // Assign the found color

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }

        // Print the result
        for (int u = 0; u < numVertices; u++) {
            System.out.println("Vertex " + u + " --->  Color " + result[u]);
        }
    }

    public static void main(String[] args) {
        GraphColoring g = new GraphColoring(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);

        System.out.println("Coloring of graph:");
        g.greedyColoring();
    }
}
