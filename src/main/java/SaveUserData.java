import dataAccessObject.Server;
import domain.Client;

public class SaveUserData {
    public static void main(String[] args) {

        Client client = new Client();
        client.setURL("localhost:1235");
//        System.out.println("Your URL: " + client.getURL());


//        HTTPResponse http = new HTTPResponse();
//        System.out.println(http.getTimeResponse());
//        System.out.println(http.getHTTPResponseCode(client));
//        System.out.println(http.getHTTPResponseLine());
//        System.out.println(http.getResponseSize(client));

        Server s = new Server();
        s.saveInformationToDB(client);
        s.saveDescriptionToDB(client);
    }


}
