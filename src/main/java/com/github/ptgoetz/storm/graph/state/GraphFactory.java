package com.github.ptgoetz.storm.graph.state;

import java.util.Map;

import com.tinkerpop.blueprints.Graph;

public interface GraphFactory {
    public Graph makeGraph(Map conf);
}
