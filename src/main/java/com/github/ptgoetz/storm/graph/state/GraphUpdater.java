package com.github.ptgoetz.storm.graph.state;

import storm.trident.operation.TridentCollector;
import storm.trident.state.BaseStateUpdater;
import storm.trident.tuple.TridentTuple;

import java.util.List;


public class GraphUpdater extends BaseStateUpdater<GraphState> {

    private GraphTupleProcessor processor;
    
    public GraphUpdater(GraphTupleProcessor processor){
        this.processor = processor;
    }


    @Override
    public void updateState(GraphState state, List<TridentTuple> tuples, TridentCollector collector) {
        state.update(tuples, collector, this.processor);
    }

}
