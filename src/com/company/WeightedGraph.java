package com.company;
import java.util.*;

public class WeightedGraph <Vertex>{
    private final boolean undirected;
    private Map<V, List<Vertex<V>>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex V) {
        map.put(V, new LinkedList<>());
    }

    public void addVertex(Vertex source, Vertex destination, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(destination))
            addVertex(destination);

        if (hasEdge(source, destination)
                || source.equals(destination))
            return; // reject parallels & self-loops

        map.get(source).add(new Vertex<>(source, destination, weight));

        if (undirected)
            map.get(destination).add(new Vertex<>(destination, source, weight));
    }

    public int getVerticesCount() {
        int count = 0;
        for (Vertex V : map.keySet()) {
            count += map.get(V).size();
        }

        if (undirected)
            count /= 2;

        return count;

    }

    public int getEdgesCount() {
        return map.size();
    }


    public boolean hasEdge(Vertex V) {
        return map.containsKey(V);
    }

    public boolean hasVertex(V source, V destination) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(new Vertex<>(source, destination));
    }

    public List<Vertex> adjacentVertices(Vertex V) {
        if (!hasVertex(V)) return null;
        List<Vertex> vertices = new LinkedList<>();
        for (Vertex<V> e : map.get(V)) {
            vertices.add(e.getDest());
        }
        return vertices;
    }

    public Iterable<Vertex<V>> getVertex(Vertex V) {
        if (!hasVertex(V)) return null;
        return map.get(V);
    }
}




}
