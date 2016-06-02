package com.joyfulmath.agileexample.activeobject;

import com.joyfulmath.agileexample.command.CommandInterface;

import java.util.Date;

/**
 * @author deman.lu
 * @version on 2016-06-02 15:05
 */
public class SleepCommand implements CommandInterface {
    @Override
    public void execute() {
        Date currentTime = new Date();
        if (!started) {
            started = true;
            this.startTime = currentTime;
            this.engine.addCommand(this);
        } else {
            long elapsedTime = currentTime.getTime() - startTime.getTime();
            if (elapsedTime < SleepTime) {
                this.engine.addCommand(this);
            } else {
                this.engine.addCommand(this.wakeupCommand);
            }
        }
    }

    private CommandInterface wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long SleepTime = 0;
    private Date startTime;
    private boolean started = false;

    public SleepCommand(long milliSeconds, ActiveObjectEngine e,
                        CommandInterface wakeupCommand) {
        this.SleepTime = milliSeconds;
        this.engine = e;
        this.wakeupCommand = wakeupCommand;
    }

}
