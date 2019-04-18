package fr.hoc.dap.swingclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
* The application DisplayClient
* displays mails&events from an user account on google
* it could add new user too!*
* @author house_Mecrob
* @version 1.0
* @since 2019-03-21
*/
public class MultiUser extends JFrame implements ActionListener {

    /**
     * 
     */
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
                // TODO, ouvre les infos mail au premier clic, et event au deuxième. (normal l'adresse est en dur pour le display)

            } catch (Exception e) {
              //TODO cbr by Djer |Gestion Exception| Utilise un Logger pluto que le .printStackTrace() qui affiche directement (en crade) dans la console
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
