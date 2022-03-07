package com.phonepe.project.models;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LevelCache {
    Integer levelNumber;
    Integer readTime;
    Integer writeTime;
    Integer capacity;
    HashMap<String, String> node;
    Deque<String> deque;

    public LevelCache(Integer levelNumber, Integer readTime, Integer writeTime, Integer capacity) {
        this.levelNumber = levelNumber;
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.capacity = capacity;
        this.node = new HashMap<String, String>();
        this.deque = new LinkedList<String>();
    }
}
