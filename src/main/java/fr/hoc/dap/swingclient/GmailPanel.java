package fr.hoc.dap.swingclient;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The application DisplayClient
 * displays mails & events from an user account on google
 * it could add new user too !
 * @author house_Mecrob
 * @version 1.0
 * @since 2019-03-21
 */
@SuppressWarnings("serial")
public class GmailPanel extends JPanel implements ActionListener {

  //TODO cbr by Djer |POO| Il faut préciser la porté de ton attribut sinon il aura la porté de la Classe par defaut (très très souvent "public")
    String nbUnread = null;
    String URL = "http://localhost:8080//email/nbunread?userKey=";

    private JLabel lbl2;
    String userKey = "mecrob"; // TODO adresse en dur 

    public GmailPanel() {
        try {
            nbUnread = ServerService.getData(URL + userKey);
        } catch (Exception e) {
            nbUnread = "error";
        }

        //On définit le layout à utiliser sur le content pane
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(200, 400);

        JLabel lbl1 = new JLabel();
        lbl1.setText("  Vous avez  :  ");
        this.add(lbl1);

        lbl2 = new JLabel();
        lbl2.setText(nbUnread);
        this.add(lbl2);

        JLabel lbl3 = new JLabel("  email(s) non lu(s).");
        this.add(lbl3);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            lbl2.setText(ServerService.getData(URL + userKey));
        } catch (Exception e1) {
            lbl2.setText("error");
        }
    }

}
