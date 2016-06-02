package com.joyfulmath.agileexample.activeobject;

import com.joyfulmath.agileexample.command.CommandInterface;

import junit.framework.Assert;

import java.util.Date;

/**
 * @author deman.lu
 * @version on 2016-06-02 14:59
 */
public class TestSleepCommand {

    class WakeUpCommand implements CommandInterface{
        public boolean executed = false;
        @Override
        public void execute() {
            this.executed = true;
        }
    }

    public void TestSleep()
    {
        WakeUpCommand wakeup = new WakeUpCommand();
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);

        Date start = new Date();
        e.run();
        Date stop = new Date();
        double sleepTime = stop.getTime()-start.getTime();

        Assert.assertTrue(String.format("SleepTime {%d} expected > 1000", sleepTime),sleepTime >= 1000);
        Assert.assertTrue(String.format("SleepTime {%d} expected < 1100", sleepTime),sleepTime <= 1100);
        Assert.assertTrue(String.format("Command Executed", sleepTime),wakeup.executed);
    }
}
