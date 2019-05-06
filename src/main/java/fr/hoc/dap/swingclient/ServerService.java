package fr.hoc.dap.swingclient;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The application DisplayClient
 * displays mails & events from an user account on google
 * it could add new user too !
 * @author house_Mecrob
 * @version 1.0
 * @since 2019-03-21
 */
public class ServerService {
    private static final String URL = "http://localhost:8080/";
    /**Logger display messages for dev in a file.*/
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Let's build our connection !
     * @param myurl  open & close connections.
     * @return connection result if true.
     * @throws Exception if input errors occurs.
     */
    public static String getData(final String myurl) throws Exception {
        URL url;
        BufferedReader reader;
        StringBuilder stringBuilder;

        url = new URL(myurl); // TODO MOI pb multi user
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15 * 1000);
        connection.connect();
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        stringBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        return stringBuilder.toString();

    }

    //    ServerService(String userKey) throws Exception {
    //        ServerService.getData(userKey);
    //        ServerService.addAccount("http://localhost:8080/account/add/{userId}");
    //        // Desktop.getDesktop().browse(new URI("http://localhost:8080/account/add/pseudo"));
    //        ServerService.getDataUnread("/email/nbunread?userKey=" + userKey);
    //        ServerService.getDataEvent("/event/next?userKey=" + userKey);
    //    }

    static void getDataEvent(String userKey) {
        URI event;
        Desktop browser = Desktop.getDesktop();
        try {
            event = new URI(URL + "/event/next?userKey=" + userKey);
            browser.browse(event);
        } catch (URISyntaxException | IOException e) {
            // e.printStackTrace();
            LOG.info("nextEvent error", e);
        }

    }

    // private static String URL = "http://localhost:8080/";
    static void getDataUnread(String userKey) {
        URI mail;
        Desktop browser = Desktop.getDesktop();
        try {
            mail = new URI(URL + "/email/nbunread?userKey=" + userKey);
            browser.browse(mail);
        } catch (URISyntaxException | IOException e) {
            // e.printStackTrace();
            LOG.info("unreadEmail error", e);
        }
    }

    static void addAccount(String userKey) {
        URI account;
        Desktop browser = Desktop.getDesktop();
        try {
            account = new URI(URL + "/account/add/" + userKey);
            browser.browse(account);
        } catch (URISyntaxException | IOException e) {
            //e.printStackTrace();
            LOG.info("accountAdd error", e);
        }
    }

}
