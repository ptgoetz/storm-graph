package com.github.ptgoetz.storm.graph.state;

import java.util.List;

import com.tinkerpop.blueprints.Graph;

import storm.trident.operation.TridentCollector;
import storm.trident.state.BaseStateUpdater;
import storm.trident.tuple.TridentTuple;

public class GraphUpdater extends BaseStateUpdater<GraphState> {

    private GraphTupleProcessor processor;
    
    public GraphUpdater(GraphTupleProcessor processor){
        this.processor = processor;
    }
    
    public void updateState(GraphState state, List<TridentTuple> tuples, TridentCollector collector) {
        state.update(tuples, collector, this.processor);
    }

}
