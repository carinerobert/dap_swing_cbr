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
 * @author house_Mecrob
 * @version 1.0
 * @since 2019-03-21
 */
@SuppressWarnings("serial")
//TODO cbr by Djer |Swing| Cette classe devrait plutot s'appeler "AccountFrame"
public class AccountPanel extends JFrame implements ActionListener {
    //TODO cbr by Djer |JavaDoc| Le @author est inutile
    /**@author display errors.*/
    private static final Logger LOG = LogManager.getLogger();

    public JButton addUser = new JButton();
    public JTextField userNew = new JTextField();

    public AccountPanel() {
        //TODO cbr by Djer |Swing| Il y a deja une instance de JButon dans ton attribut. Tu peux faire un : addUser.setText("Ajouter")
        addUser = new JButton("Ajouter");
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
              //TODO cbr by Djer |Swing| Si tu créer des Panel sans les Ajouter dans le Layout d'une Frame ils ne seront pas visibles.
                new AccountPanel();
                ServerService.addAccount(URL + userKey);
                //TODO cbr by Djer |Swing| Si tu créer des Panel sans les Ajouter dans le Layout d'une Frame ils ne seront pas visibles.
                new GmailPanel();
                ServerService.getDataUnread(userKey);
                //TODO cbr by Djer |Swing| Si tu créer des Panel sans les Ajouter dans le Layout d'une Frame ils ne seront pas visibles.
                new EventPanel();
                ServerService.getDataEvent(userKey);

                LOG.info("connect " + userKey);
            }

            LOG.error("Connection aborted " + userKey);
        }
    }
}
