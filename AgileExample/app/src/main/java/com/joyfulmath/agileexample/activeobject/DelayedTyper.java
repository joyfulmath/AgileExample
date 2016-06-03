package com.joyfulmath.agileexample.activeobject;

import com.joyfulmath.agileexample.TraceLog;
import com.joyfulmath.agileexample.command.CommandInterface;

/**
 * @author deman.lu
 * @version on 2016-06-02 15:51
 */
public class DelayedTyper implements CommandInterface {
    private long itsDelay;
    private char itsChar;
    private static boolean stop = false;
    static String printStr = "";
    private static ActiveObjectEngine engin =
            new ActiveObjectEngine();

    static class StopCommand implements CommandInterface
    {
        @Override
        public void execute() {
            DelayedTyper.stop = true;
        }
    }

    public static void Main()
    {
        engin.addCommand(new DelayedTyper(100, 'A'));
        engin.addCommand(new DelayedTyper(300, 'B'));
        engin.addCommand(new DelayedTyper(500, 'C'));
        engin.addCommand(new DelayedTyper(700, 'D'));

        CommandInterface stopCommand = new StopCommand();
        engin.addCommand(new SleepCommand(2000, engin, stopCommand));
        engin.run();
    }

    public DelayedTyper(long delay, char c)
    {
        this.itsDelay = delay;
        this.itsChar = c;
    }

    @Override
    public void execute()
    {
        printStr +=itsChar;
        if (!stop)
        {
            DelayAndRepeat();
        }
    }

    private void DelayAndRepeat()
    {
        engin.addCommand(new SleepCommand(itsDelay, engin, this));
    }
}
