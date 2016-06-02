package com.joyfulmath.agileexample.command;

/**
 * @author deman.lu
 * @version on 2016-06-02 10:38
 */
public class ContractCommand implements CommandInterface {
    Member member;

    public ContractCommand(Member member) {
        this.member = member;
    }

    @Override
    public void execute() {
        member.action();
    }
}
