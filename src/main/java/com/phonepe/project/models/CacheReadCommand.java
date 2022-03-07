package com.phonepe.project.models;

public class CacheReadCommand implements CacheCommand {

    MultiLevelCache multiLevelCache;
    String key;

    public CacheReadCommand(MultiLevelCache multiLevelCache, String key) {
        this.multiLevelCache = multiLevelCache;
        this.key = key;
    }
    public void execute() {
        Boolean found = false;
        Integer targetLevel = -1;
        Integer readTimeTaken = 0;
        String keyValue = new String();
        for(Integer i=0;i < multiLevelCache.levels; i++) {
            if(multiLevelCache.levelCaches.get(i).node.containsKey(key)) {
                String value = multiLevelCache.levelCaches.get(i).node.get(key);
                multiLevelCache.levelCaches.get(i).deque.remove(key);
                multiLevelCache.levelCaches.get(i).node.remove(key);
                readTimeTaken += multiLevelCache.levelCaches.get(i).readTime;
                found = true;
                targetLevel = i+1;
                keyValue = value;

                Integer evictionLevel = 0;
                while(found==true && evictionLevel <= i) {
                    multiLevelCache.levelCaches.get(evictionLevel).deque.addFirst(key);
                    multiLevelCache.levelCaches.get(evictionLevel).node.put(key, value);
                    readTimeTaken += multiLevelCache.levelCaches.get(evictionLevel).writeTime;
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
                break;
            }
        }
        if(found == false) {
            System.out.println(" Key not found: ");
        }
        else {
            System.out.println("Key found at level: " + targetLevel + " Value: " + keyValue);
            System.out.println("Read Time: " + readTimeTaken);
        }
        CacheCommonUtils.prinntCache(multiLevelCache);
    }

}
