package dataAccessObject;


import domain.Client;
import org.junit.Test;

public class ServerTest {

    @Test
    public void addClient(){
        Server server = new Server();
        server.saveDescriptionToDB(saveClient());
    }

    public Client saveClient() {
        Client client = new Client();
        client.setURL("localhost:8080");
        return client;
    }

//    public Client saveClient404() {
//        Client client = new Client();
//        client.setURL("localhost:1111");
//        return client;
//    }


}
