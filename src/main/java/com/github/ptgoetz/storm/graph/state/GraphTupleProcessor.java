package com.github.ptgoetz.storm.graph.state;

import com.tinkerpop.blueprints.Graph;

import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public interface GraphTupleProcessor {

    public void process(Graph g, TridentTuple tuple, TridentCollector collector);

}
