package com.phonepe.project.utils;

import com.phonepe.project.models.MultiLevelCache;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheWriteCommand implements CacheCommand{

    MultiLevelCache multiLevelCache;
    String key;
    String value;
    @Autowired
    CacheCommonUtils cacheCommonUtils;

    public CacheWriteCommand(MultiLevelCache multiLevelCache, String key, String value) {
        this.multiLevelCache = multiLevelCache;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        Integer evictionLevel = 0;
        Integer writeTimeTaken = 0;
        while(evictionLevel < multiLevelCache.levels) {
            multiLevelCache.levelCaches.get(evictionLevel).deque.addFirst(key);
            multiLevelCache.levelCaches.get(evictionLevel).node.put(key, value);
            writeTimeTaken += multiLevelCache.levelCaches.get(evictionLevel).writeTime;
            if(multiLevelCache.levelCaches.get(evictionLevel).deque.size() > multiLevelCache.levelCaches.get(evictionLevel).capacity) {
                key = multiLevelCache.levelCaches.get(evictionLevel).deque.removeLast();
                value = multiLevelCache.levelCaches.get(evictionLevel).node.get(key);
                multiLevelCache.levelCaches.get(evictionLevel).node.remove(key);
            }
            else {
                break;
            }
            evictionLevel++;
        }
        System.out.println("Write Time: " + writeTimeTaken);
        cacheCommonUtils.printCache(multiLevelCache);
    }
}
