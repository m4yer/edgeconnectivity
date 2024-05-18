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

        // graph has to be not planar initially
        if (planarityTester.isPlanar()) {
            return false;
        }

        for (var edge : graph.getEdges()) {
            planarityTester.removeEdge(edge.getFromV(), edge.getToV());

            // check if graph is planar by deleting edge
            if (planarityTester.isPlanar()) {
                System.out.println("Graph became planar after removing " + edge.getFromV() + " and " + edge.getToV());
                return true;
            }

            planarityTester.addEdge(edge.getFromV(), edge.getToV());
        }

        return false;
    }

}
