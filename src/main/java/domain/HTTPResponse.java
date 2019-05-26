package domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTPResponse {

    private LocalTime timeResponse;
    private int responseCode;
    private String responseLine;
    private String responseSize;
    private List siteList;
    private Map siteDesc;


    public int getHTTPResponseCode(Client client) {
        siteList = new ArrayList();
        siteList.add("localhost:8080");
        siteList.add("localhost:2223");
        siteList.add("localhost:1234");
        siteList.add("localhost:7072");

        if (siteList.contains(client.getURL())) {
            setResponseCode(200);
        } else {
            setResponseCode(404);
        }
        return getResponseCode();
    }

    public String getHTTPResponseLine() {
        if (getResponseCode() == 200) {
            setResponseLine("SUCCESSFULL!");
        } else {
            setResponseLine("NOT FOUND!");
        }
        return getResponseLine();
    }

    public String getResponseSize(Client client) {
        siteDesc = new HashMap();
        siteDesc.put(200, "Request successfully complete!");
        siteDesc.put(201, "Resource is created!");
        siteDesc.put(401, "You need authentication!");
        siteDesc.put(404, "Server can't find resource!");

        responseSize = siteDesc.get(getHTTPResponseCode(client)).toString();
        return responseSize;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseLine(String responseLine) {
        this.responseLine = responseLine;
    }

    public String getResponseLine() {
        return responseLine;
    }

    @Override
    public String toString() {
        return "HTTPResponse{" +
                "timeResponse=" + timeResponse +
                ", responseCode=" + responseCode +
                ", responseLine='" + responseLine + '\'' +
                ", responseSize=" + responseSize +
                '}';
    }
}
