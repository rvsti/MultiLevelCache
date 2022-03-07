package com.phonepe.project.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
@ConfigurationProperties(prefix = "conf")
public class CacheConfigProperties {
    public Integer levels;

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public List<Integer> getCapacity() {
        return capacity;
    }

    public void setCapacity(List<Integer> capacity) {
        this.capacity = capacity;
    }

    public List<Integer> capacity;
    public List<Integer> readTime;

    public List<Integer> getReadTime() {
        return readTime;
    }

    public void setReadTime(List<Integer> readTime) {
        this.readTime = readTime;
    }

    public List<Integer> getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(List<Integer> writeTime) {
        this.writeTime = writeTime;
    }

    public List<Integer> writeTime;

}
