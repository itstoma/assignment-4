package com.company;
import java.nio.FloatBuffer;
import java.util.*;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;
    private V source;
    private V destination;
    private Double weight;

    public Vertex(V source, V destination, Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex(V source, V destination) {
        this.source = source;
        this.destination = destination;
    }

    public void setSource(V source) {
        this.source = source;
    }

    public V getSource() {
        return source;
    }

    public void setDest(V destination) {
        this.destination = destination;
    }

    public V getDest() {
        return destination;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacentVertices.put(destination,weight);
    }
    public void addVertex(Vertex V){
        map.put(V,new LinkedList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex v = (Vertex) o;
        return Objects.equals(source, v.source) &&
                Objects.equals(destination, v.destination);
    }

}
