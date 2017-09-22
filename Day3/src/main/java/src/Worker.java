package src;

import java.net.HttpURLConnection;
import java.net.URL;

public class Worker implements Runnable{
    
    private String result = "Error";
    private String url;
    
    
    public Worker(String url){
        this.url = url;
    }
    @Override
    public void run() {
         
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
 
            int code = connection.getResponseCode();
            if (code == 200) 
                result = "Green";
            if(code==301)
                result="Redirect";
        } catch (Exception e) {
            result = "->Red<-";
        }
        Callable.add((url + " \tStatus:" + result));
    }
       
    }


