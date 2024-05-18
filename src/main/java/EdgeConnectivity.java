import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

public class EdgeConnectivity implements GraphProperty {

    @Override
    public boolean execute(Graph graph) {
        var planarityTester = new PlanarityTester(graph.getVertices().keySet().stream().toList());

        for (Edge edge : graph.getEdges()) {
            planarityTester.addEdge(edge.getFromV(), edge.getToV());
        }

        // Graph must be non-planar initially
        if (planarityTester.isPlanar()) {
            return false;
        }

        for (var firstEdge : graph.getEdges()) {
            planarityTester.removeEdge(firstEdge.getFromV(), firstEdge.getToV());

            // Graph should remain non-planar after removing one edge
            // If that's the case then continue
            if (planarityTester.isPlanar()) {

                return true;
            }

            planarityTester.addEdge(firstEdge.getFromV(), firstEdge.getToV());
        }

        return false;
    }

}
