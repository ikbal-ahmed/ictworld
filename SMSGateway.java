/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department.mangement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;

/**
 *
 * @author Ikbal Ahmed
 */
public class SMSGateway {

    DerbyConnection connect = new DerbyConnection();
    ResultSet rs;
    String mobile;
    int i = 0;

    public void Send_SMS(String batch) {
        try {
            connect.statement = connect.connection.createStatement();
            rs = connect.statement.executeQuery("SELECT name, mobile FROM student WHERE batch1 = '" + 
                    batch + "' OR batch2 = '" + batch + "'");
            while (rs.next()) {
                String name = rs.getString(1);
                String recipient = rs.getString(2);
                System.out.println(recipient);
                String message = "Dear " + name + ", Your ICT class is running now. ICT World(Ikbal Sir). For details - please come to our office. ";
                String username = "admin";
                String password = "qwer1234";
                String originator = "01700000600";

                String requestUrl = "http://127.0.0.1:9501/api?action=sendmessage&"
                        + "username=" + URLEncoder.encode(username, "UTF-8")
                        + "&password=" + URLEncoder.encode(password, "UTF-8")
                        + "&recipient=" + URLEncoder.encode(recipient, "UTF-8")
                        + "&messagetype=SMS:TEXT"
                        + "&messagedata=" + URLEncoder.encode(message, "UTF-8")
                        + "&originator=" + URLEncoder.encode(originator, "UTF-8")
                        + "&serviceprovider=GSMModem1"
                        + "&responseformat=html";

                URL url = new URL(requestUrl);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();

                System.out.println(uc.getResponseMessage());

                uc.disconnect();
                i++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {

    }
}
