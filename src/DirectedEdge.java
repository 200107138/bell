import java.util.Map;
import java.util.Random;

public class DirectedEdge {
    private final int from;
    private final int to;
    private final int weight;
    public DirectedEdge(int from, int to, int weight, int velocity, double rate) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public int weight() {
        return weight;
    }

}
