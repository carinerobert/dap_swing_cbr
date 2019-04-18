package fr.hoc.dap.swingclient;

import java.awt.Color;
import java.awt.Dimension;
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
public class EventPanel extends JPanel implements ActionListener {
    //TODO cbr by Djer |POO| Il faut préciser la porté de ton attribut sinon il aura la porté de la Classe par defaut (très très souvent "public")
    String userKey = "mecrob"; // TODO adresse en dur 
    String nextEvent = null;
    String URL = "http://localhost:8080/event/next?userKey=";
    private JLabel lbl3;

    public EventPanel() {
        try {
            nextEvent = ServerService.getData(URL + userKey);
        } catch (Exception e) {
            nextEvent = "error";
        }
        this.setBackground(Color.magenta);
        this.setPreferredSize(new Dimension(160, 80));

        this.add(new JLabel("Votre prochain évènement : "));
        lbl3 = new JLabel(nextEvent);
        this.add(lbl3);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            lbl3.setText(ServerService.getData(URL + userKey));
        } catch (Exception e1) {
            lbl3.setText("error");
        }
    }
}
