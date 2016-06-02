package com.joyfulmath.agileexample.activeobject;

import com.joyfulmath.agileexample.command.CommandInterface;

import java.util.ArrayList;


/**
 * @author deman.lu
 * @version on 2016-06-02 14:45
 */
public class ActiveObjectEngine {
    ArrayList<CommandInterface> itsCommands = new ArrayList();

    public void addCommand(CommandInterface aCommand)
    {
        itsCommands.add(aCommand);
    }

    public void run()
    {
        while (itsCommands.size() > 0)
        {
            CommandInterface c = itsCommands.get(0);
            itsCommands.remove(0);
            c.execute();
        }
    }
}
