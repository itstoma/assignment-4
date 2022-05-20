package com.company;
import java.util.*;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacentVertices.put(destination,weight);
    }
}
