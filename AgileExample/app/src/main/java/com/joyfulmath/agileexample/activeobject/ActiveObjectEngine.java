package com.joyfulmath.agileexample.activeobject;

import com.joyfulmath.agileexample.BaseThreadUtils;
import com.joyfulmath.agileexample.TraceLog;
import com.joyfulmath.agileexample.command.CommandInterface;

import java.util.ArrayList;
import java.util.List;


/**
 * @author deman.lu
 * @version on 2016-06-02 14:45
 */
public class ActiveObjectEngine {

    public ActiveObjectEngine()
    {
        BaseThreadUtils.initWorkThread();
    }

    public void releaseEngine()
    {
        BaseThreadUtils.releaseWorkThread();
    }

    List<CommandInterface> itsCommands = new ArrayList();

    /*need to running in main thread, should check with synchronized*/
    public void addCommand(final CommandInterface aCommand) {
        TraceLog.i("itsCommands.size:" + itsCommands.size());
        itsCommands.add(aCommand);
    }

    public void run() {
        BaseThreadUtils.runInWorkThread(new Runnable() {
            @Override
            public void run() {
                while (itsCommands.size() > 0) {
                    TraceLog.i("itsCommands.size:" + itsCommands.size());
                    CommandInterface c = itsCommands.get(0);
                    itsCommands.remove(0);
                    c.execute();
                }
//                releaseEngine();
            }
        });
    }
}
