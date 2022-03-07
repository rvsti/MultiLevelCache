package com.phonepe.project.models;

import java.util.ArrayList;
import java.util.List;

public class MultiLevelCache {
    Integer levels;
    List<LevelCache> levelCaches;

    public MultiLevelCache(Integer levels, List<Integer> capacities, List<Integer> readTime, List<Integer>writeTime) {
        this.levels = levels;
        this.levelCaches = new ArrayList<LevelCache>(levels);
        for (Integer i=0; i< levels; i++) {
            this.levelCaches.add(new LevelCache(i, readTime.get(i), writeTime.get(i),  capacities.get(i)));
        }
    }

}
