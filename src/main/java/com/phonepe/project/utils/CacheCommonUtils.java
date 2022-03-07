package com.phonepe.project.utils;

import com.phonepe.project.models.LevelCache;
import com.phonepe.project.models.MultiLevelCache;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class CacheCommonUtils {

    public void printCache(MultiLevelCache multiLevelCache) {
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
