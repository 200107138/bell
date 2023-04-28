import java.util.Stack;

public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public BellmanFordSP(EdgeWeightedDigraph G, int s, int hour) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = hour;

        // Relax all edges V-1 times
        for (int i = 0; i < G.V() - 1; i++) {
            for (int v = 0; v < G.V(); v++) {
                for (DirectedEdge e : G.adj(v)) {
                    relax(e);
                }
            }
        }

        // Check for negative cycles
        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                int w = e.to();
                if (distTo[w] > distTo[v] + e.weight()) {
                    throw new IllegalArgumentException("Negative cycle detected");
                }
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();

        // Relax edge if new distance is less than current distance
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
