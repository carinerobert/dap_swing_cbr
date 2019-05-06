package fr.hoc.dap.swingclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* The application DisplayClient
* displays mails&events from an user account on google
* it could add new user too!*
* @author house_Mecrob
* @version 1.0
* @since 2019-03-21
*/
public class MultiUser extends JFrame implements ActionListener {

    /** display messages for dev in a file.*/
    private static final Logger LOG = LogManager.getLogger();

    private static final long serialVersionUID = 1L;
    public JButton connect;
    public JTextField user = new JTextField();
    public static String userKey;

    public MultiUser() {
        connect = new JButton("Connection");
        connect.addActionListener(this);
        this.setSize(360, 100);
        this.setLayout(new GridLayout());
        this.setTitle("Connection compte utilisateur");
        this.add(user);
        this.add(connect);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if (source == connect) {
            String userKey = user.getText();
            user.addActionListener(this);
            connect.addActionListener(this);

            try {
                ServerService.getDataUnread(userKey);
                ServerService.getDataEvent(userKey);

            } catch (Exception e) {
                // e.printStackTrace();
                LOG.info("", e);
            }
        }
    }
}
