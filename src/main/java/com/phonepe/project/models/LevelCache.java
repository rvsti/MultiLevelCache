package com.phonepe.project.models;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LevelCache {
    public Integer levelNumber;
    public Integer readTime;
    public Integer writeTime;
    public Integer capacity;
    public HashMap<String, String> node;
    public Deque<String> deque;

    public LevelCache(Integer levelNumber, Integer readTime, Integer writeTime, Integer capacity) {
        this.levelNumber = levelNumber;
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.capacity = capacity;
        this.node = new HashMap<String, String>();
        this.deque = new LinkedList<String>();
    }
}
