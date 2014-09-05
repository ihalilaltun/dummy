package remotemanagement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cooper
 */
public class LoadListenerHosts extends RemoteManagementWindow {

    public DefaultListModel<String> LoadListenerHosts() throws Exception {
        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            // TODO add your handling code here:
            ListenerHosts a = new ListenerHosts();
            //a.getListenerHostsFromDB();

            for (String s : a.getListenerHostsFromDB()) {
                model.addElement(s.split("#")[0] + "->" + s.split("#")[1]);
                //model.addElement(s.split("#")[1].toString());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
//            if (dbContext.getLastContext() == null
//                    || dbContext.getLastContext().length() == 0
//                    || dbContext.getLastContext().isEmpty()) {
//                dbCreditentials.setVisible(true);
//            } else {
//                dbUrlTextFld.setText(myHistory.dbCreditentialsMap.get("dbUrl"));
//                dbUserNameFld.setText(myHistory.dbCreditentialsMap.get("dbUser"));
//                dbPasswordFld.setText(myHistory.dbCreditentialsMap.get("dbPassword"));
//                dbCreditentials.pack();
//                dbCreditentials.setResizable(false);
//                dbCreditentials.setLocationRelativeTo(this);
//                dbCreditentials.setVisible(true);
//            }
        }
        return model;
    }

}
