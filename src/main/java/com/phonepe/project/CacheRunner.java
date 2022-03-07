package com.phonepe.project;

import com.phonepe.project.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CacheRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CacheConfigProperties cacheConfigProperties;

    public void run(String... args) throws Exception {

        logger.info("Levels: {}", cacheConfigProperties.levels);
        System.out.println(cacheConfigProperties.capacity);
        MultiLevelCache multiLevelCache = new MultiLevelCache(cacheConfigProperties.levels, cacheConfigProperties.capacity,
                cacheConfigProperties.readTime, cacheConfigProperties.writeTime);

        Scanner sc = new Scanner(System.in);
        System.out.println("Start\n");
        String inputCommand="";
        while(!inputCommand.equalsIgnoreCase("exit")) {
            System.out.println("Enter Command\n");
            inputCommand = sc.nextLine();
            System.out.println(inputCommand);
            if(inputCommand.startsWith("READ")) {
                String[] ar = inputCommand.split(" ");
                CacheReadCommand cacheReadCommand = new CacheReadCommand(multiLevelCache, ar[1]);
                cacheReadCommand.execute();

            }
            else if(inputCommand.startsWith("WRITE")) {
                String[] ar = inputCommand.split(" ");
                CacheWriteCommand cacheWriteCommand = new CacheWriteCommand(multiLevelCache, ar[1], ar[2]);
                cacheWriteCommand.execute();
            }
            else if(inputCommand.startsWith("DISPLAY")) {
                CacheCommonUtils.prinntCache(multiLevelCache);
            }
        }


    }

}
