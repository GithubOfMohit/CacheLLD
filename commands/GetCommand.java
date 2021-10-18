package com.cachelld.commands;

import com.cachelld.cache.Cache;
import com.cachelld.cache.factory.CacheFactory;

public class GetCommand implements ICommand{
    private static GetCommand getCommandInstance;
    private Cache<Integer,Integer> cache;
    private GetCommand() {
        cache = CacheFactory.getInstance().getDefaultCache();
    }

    public static GetCommand getInstance() {
        if (getCommandInstance == null) {
            getCommandInstance = new GetCommand();
        }
        return getCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) {
        Integer key = Integer.valueOf(cmd[1]);
        System.out.println("Getting Access Key");
        cache.getKey(key);

    }
}
