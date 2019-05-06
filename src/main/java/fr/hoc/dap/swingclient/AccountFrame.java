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
 * displays mails & events from an user on google's account
 * it could add new user too !
 */
@SuppressWarnings("serial")
public class AccountFrame extends JFrame implements ActionListener {

    /** display messages for dev in a file.*/
    private static final Logger LOG = LogManager.getLogger();

    public JButton addUser = new JButton();
    public JTextField userNew = new JTextField();

    public AccountFrame() {
        addUser.setText("Ajouter");
        addUser.addActionListener(this);
        userNew.addActionListener(this);
        //        JButton enter = new JButton("Entrer");
        //        enter.setMnemonic(KeyEvent.VK_ENTER);

        this.setSize(360, 100);
        this.setLayout(new GridLayout());
        this.setTitle("Création compte utilisateur");
        this.add(userNew);
        this.add(addUser);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String URL = "http://localhost:8080/";
        Object source = event.getSource();
        if (source == addUser) {
            final String userKey = userNew.getText();

            if (source == addUser) {
                //TODO S AFFICHE DANS LE BROWSER 50% resolu cbr by Djer |Swing| Si tu créer des Panel sans les Ajouter dans le Layout d'une Frame ils ne seront pas visibles.
                // new AccountFrame();
                new MenuPanel();
                ServerService.addAccount(URL + userKey);
                this.setLayout(new GridLayout());

                //TODO cbr by Djer |Swing| Si tu créer des Panel sans les Ajouter dans le Layout d'une Frame ils ne seront pas visibles.
                new GmailPanel();
                ServerService.getDataUnread(userKey);
                this.setLayout(new GridLayout());

                //TODO cbr by Djer |Swing| Si tu créer des Panel sans les Ajouter dans le Layout d'une Frame ils ne seront pas visibles.
                new EventPanel();
                ServerService.getDataEvent(userKey);
                this.setLayout(new GridLayout());

                LOG.info("connect " + userKey);
            }

            LOG.error("Connection aborted " + userKey);
        }
    }
}
