package com.joyfulmath.agileexample.command;

/**
 * @author deman.lu
 * @version on 2016-06-02 10:44
 */
public class Manager {
    public static void main()
    {
        Member m = new Member();
        CommandInterface c = new ContractCommand(m);
        Leader wang2 = new Leader();

        wang2.setCommandInterface(c);
        wang2.executeCommand();
    }
}
