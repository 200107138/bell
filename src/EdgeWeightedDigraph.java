import java.util.*;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private List<List<DirectedEdge>> adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj.get(v).add(e);
        E++;
    }

    public List<DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    public List<DirectedEdge> edges() {
        List<DirectedEdge> edges = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                edges.add(e);
            }
        }
        return edges;
    }
}
