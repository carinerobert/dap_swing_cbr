package fr.hoc.dap.swingclient;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The application DisplayClient
 * displays mails & events from an user account on google
 * it could add new user too !
 * @author house_Mecrob
 * @version 1.0
 * @since 2019-03-21
 */
@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener {

    private JButton refreshButton;
    private JButton userButton;
    private JButton addButton;
    public JButton connect;

    public MenuPanel() {

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new FlowLayout());

        this.setPreferredSize(new Dimension(150, 0));
        this.setBorder(new EmptyBorder(40, 0, 0, 0));

        refreshButton = new JButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(120, 60));
        this.add(refreshButton);

        userButton = new JButton("User");
        userButton.setPreferredSize(new Dimension(120, 60));
        userButton.addActionListener(this);
        this.add(userButton);

        addButton = new JButton("New");
        addButton.setPreferredSize(new Dimension(120, 60));
        addButton.addActionListener(this);
        this.add(addButton);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == refreshButton) {
            new GmailPanel();
            new EventPanel();

        } else if (event.getSource() == userButton) {
            new MultiUser();
        }
        if (event.getSource() == connect) {
            new GmailPanel();
            new EventPanel();

        } else if (event.getSource() == addButton) {
            new AccountPanel();

        }
    }

    public void registerRefresh(ActionListener listener) {
        refreshButton.addActionListener(listener);

    }

}
