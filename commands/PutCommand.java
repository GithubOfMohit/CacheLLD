package com.cachelld.commands;

import com.cachelld.cache.Cache;
import com.cachelld.cache.factory.CacheFactory;

public class PutCommand implements ICommand{

    private static PutCommand putCommandInstance;
    private Cache cache;
    private PutCommand() {
        cache = CacheFactory.getInstance().getDefaultCache();
    }

    public static PutCommand getInstance() {
        if (putCommandInstance == null) {
            putCommandInstance = new PutCommand();
        }
        return putCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) {
        Integer key = Integer.valueOf(cmd[1]);
        Integer value = Integer.valueOf(cmd[2]);
        System.out.println("Adding (Key, Value) -> " + key + ", " + value);
        cache.putKey(key,value);
    }
}
