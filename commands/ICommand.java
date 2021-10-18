package com.cachelld.commands;

import com.cachelld.exceptions.BadCommandException;

public interface ICommand {
    void executeCommand(String cmd[]) throws BadCommandException;
}
