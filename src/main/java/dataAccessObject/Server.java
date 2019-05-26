package dataAccessObject;

import domain.Client;
import domain.HTTPResponse;
import domain.Monitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;

public class Server extends Monitoring{

    private static final String USER_DATA = "INSERT INTO monitoring(" +
            "                      site_url, site_status)"+
            "                    VALUES (?, ?);";

    private static final String DATA_DESC = "INSERT INTO description(" +
            "                           monitoring_period, response_code, response_line, response_size)" +
            "                   VALUES (?, ?, ?, ?);";


    public static Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    public void saveInformationToDB(Client client) {

        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(USER_DATA)) {

                ps.setString(1, client.getURL());
                ps.setString(2, client.checkNumConnection());
                ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void saveDescriptionToDB(Client client) {
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DATA_DESC)){

            Monitoring monitoring = new Monitoring();
            if(client.getUrlStatus().equals("OK")) {
                ps.setTime(1, java.sql.Time.valueOf(LocalTime.now()));
                ps.setInt(2, client.getHTTPResponseCode(client));
                ps.setString(3, client.getHTTPResponseLine());
                ps.setString(4, client.getResponseSize(client));
                ps.executeUpdate();
            }else {
                ps.setTime(1, null);
                ps.setInt(2, getHttpResponse().getResponseCode());
                ps.setString(3, null);
                ps.setInt(4, 0);
                ps.executeUpdate();
            }


        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }

    }
}
