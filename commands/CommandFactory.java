package com.cachelld.commands;

import com.cachelld.exceptions.BadCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements ICommand{


    private static CommandFactory commandFactoryInstance;
    private Map<String,ICommand> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("Put",PutCommand.getInstance());
        commandMap.put("Get",GetCommand.getInstance());

    }

    public static CommandFactory getInstance() {
        if (commandFactoryInstance == null) {
            commandFactoryInstance = new CommandFactory();
        }
        return commandFactoryInstance;
    }

    @Override
    public void executeCommand(String[] cmd) {
        try {
            commandMap.get(cmd[0]).executeCommand(cmd);
        } catch (BadCommandException e) {
            e.printStackTrace();
        }
    }
}
