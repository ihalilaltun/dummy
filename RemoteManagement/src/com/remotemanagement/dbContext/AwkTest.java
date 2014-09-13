/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.dbContext;

import com.remotemanagement.linuxCommands.RetreiveAgentLocationCommand;
import org.grep4j.core.command.linux.JschCommandExecutor;
import org.grep4j.core.model.ServerDetails;
import remotemanagement.RemoteManagementWindow;

/**
 *
 * @author cooper
 */
public class AwkTest {

    private static RetreiveAgentLocationCommand command;

    public static void main(String args[]) {

        ServerDetails myDetails = new ServerDetails("10.248.66.149");
        myDetails.setPassword("evam123");
        myDetails.setUser("evam");
        myDetails.setPasswordRequired(true);

        JschCommandExecutor b;
        b = new JschCommandExecutor(myDetails);
        command = new RetreiveAgentLocationCommand();
        if (b.execute(command).andReturnResult().toString() == null | b.execute(command).andReturnResult().toString().isEmpty()) {
            System.out.println("No Agent instances is running");
        }
        System.out.println(b.execute(command).andReturnResult());
    }
}
