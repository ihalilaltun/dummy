/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.linuxCommands;

import org.grep4j.core.command.ExecutableCommand;

/**
 *
 * @author cooper
 */
public class RetreiveAgentLocationCommand implements ExecutableCommand {

    //pwdx $(pgrep java) | grep -i file | awk '!a[$2]++ {print $2}'
    private static final String AGENT_LOCATION_COMMAND = "pwdx $(pgrep java) | grep -i file | awk '!a[$2]++ {print $2}'";
//    private final String host;

//    public RetreiveAgentLocationCommand() {
//    }

    @Override
    public String getCommandToExecute() {
        StringBuilder command = new StringBuilder();
        command.append(AGENT_LOCATION_COMMAND);

        //System.out.print(command);
        return command.toString();
    }

}
