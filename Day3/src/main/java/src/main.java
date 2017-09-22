package src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class main {

        public static void main(String[] args) {
        
                String[] hostList = { "http://crunchify.com", "http://yahoo.com",
                "http://www.ebay.com", "http://google.com",
                "http://www.example.co", "https://paypal.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://cphbusiness.dk/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://dr.dk","http://pol.dk","https://www.google.dk",
                "http://phoronix.com" ,"http://www.webupd8.org/",
                "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
                "http://docs.oracle.com","https://fronter.com",
                "http://imgur.com/", "http://www.imagemagick.org"
                };
                
                ExecutorService executor = Executors.newFixedThreadPool(10);
                
                for(String i: hostList){
                    Runnable worker = new Worker(i);
                    executor.execute(worker); 
                }
                
                executor.shutdown();
                                
                while(!executor.isTerminated()){}
                
                Callable.printAll();
    }

}
