package com.github.ptgoetz.storm.graph.state;

import com.tinkerpop.blueprints.Graph;

import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public interface GraphTupleProcessor {

    /**
     * Given a <code>TridentTuple</code>, update a <code>Graph</code> object and optionally
     * emit tuples to a <code>TridentColector</code> object.
     *
     * @param g the Graph to modify
     * @param tuple the incoming data
     * @param collector the collector to emit to
     */
    public void process(Graph g, TridentTuple tuple, TridentCollector collector);

}
