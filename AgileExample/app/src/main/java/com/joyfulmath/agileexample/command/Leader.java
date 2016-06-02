package com.joyfulmath.agileexample.command;

/**
 * @author deman.lu
 * @version on 2016-06-02 10:42
 */
public class Leader {
    CommandInterface commandInterface;


    public void setCommandInterface(CommandInterface commandInterface) {
        this.commandInterface = commandInterface;
    }

    public void executeCommand()
    {
        commandInterface.execute();
    }
}
