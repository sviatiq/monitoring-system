package domain;

public class Monitoring extends HTTPResponse{

    private String urlStatus;
    private HTTPResponse httpResponse;
    private int connectionNum;

    public String getUrlStatus() {
        return urlStatus;
    }

    public void setUrlStatus(String urlStatus) {
        this.urlStatus = urlStatus;
    }

    public HTTPResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HTTPResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public int getConnectionNum() {
        return connectionNum;
    }

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public int generateConnections(){
        connectionNum = (int)(1+Math.random()*24);
        return connectionNum;
    }

    public String checkNumConnection(){
        generateConnections();
        if(connectionNum>=20){
            setUrlStatus("CRITICAL");
        }else if(connectionNum>=15 && connectionNum<=19){
            setUrlStatus("WARNING");
        }else{
            setUrlStatus("OK");
        }
        return getUrlStatus();
    }
}
