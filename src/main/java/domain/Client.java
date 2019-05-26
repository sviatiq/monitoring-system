package domain;

public class Client extends Monitoring{

    private String URL;

    public Client() {
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }


    @Override
    public String toString() {
        return "Client{" +
                "URL='" + URL + '\'' +
                '}';
    }
}
