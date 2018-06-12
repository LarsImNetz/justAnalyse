package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class TutorialServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("start");
    
        // erzeugen des Jetty Servers auf port 8080
        Server server = new Server(8080);
        // setup Handler - hier wird noch erweitert
    
        
        // erzeugen der Handlerliste
        HandlerList handlerlist = new HandlerList();

        // erzeuge Filter mit dem context /test
        ContextHandler cont = new ContextHandler("/test");
        // filter ruft erneut unser eigenen Handler auf
        cont.setHandler(new MyTestHandler());
        // filer auf die Liste  
        handlerlist.addHandler(cont);
        // server erhält die liste    
        server.setHandler(handlerlist);

        /*
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{"index.html"});
        //das locale verzeichnis auf dem Rechner setzen - muss euren gegebenheiten angepasst werden !
        resource_handler.setResourceBase("/home/susi/homepage/www.net-wolf.de"); //das locale verzeichnis auf dem Rechner

        ContextHandler chtm = new ContextHandler("/html");
        chtm.setHandler(resource_handler);
        // der neue Handler auf die Liste
        handlerlist.addHandler(chtm);
        */    
        
        // und start Server
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
