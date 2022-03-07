package com.phonepe.project.models;

import java.util.Iterator;

public class CacheCommonUtils {

    public static void prinntCache(MultiLevelCache multiLevelCache) {
        for(Integer i = 0; i < multiLevelCache.levels; i++) {
            System.out.println("Level: " + (i + 1));
            LevelCache levelCache = multiLevelCache.levelCaches.get(i);
            Iterator<String> it = levelCache.deque.iterator();
            while(it.hasNext()) {
                String key = it.next();
                System.out.println("Key: " + key + " Value: " + levelCache.node.get(key));
            }
        }
    }
}
