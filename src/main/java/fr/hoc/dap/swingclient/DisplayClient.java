package fr.hoc.dap.swingclient;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The application DisplayClient
 * displays mails & events from an user account on google
 * it could add new user too !
 * @author house_Mecrob
 * @version 1.0
 * @since 2019-03-21
 */
@SuppressWarnings("serial")
public class DisplayClient extends JFrame {

    public static void main(String[] args) throws Exception {
        new DisplayClient();
    }

    public DisplayClient() throws Exception {

        this.setTitle("Data Access Project   *}");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pour que la fenetre soit toujours au premier plan
        // this.setAlwaysOnTop(true);
        // pour que la taille de la fenetre soit modifiable avec la souris 
        this.setResizable(true);

        //Instanciation d'objets JPanel
        MenuPanel menu = new MenuPanel();
        GmailPanel mailPan = new GmailPanel();
        EventPanel eventPan = new EventPanel();

        menu.registerRefresh(mailPan);
        menu.registerRefresh(eventPan);

        this.getContentPane().add(menu, BorderLayout.WEST);
        this.getContentPane().add(mailPan, BorderLayout.CENTER);
        this.getContentPane().add(eventPan, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
