package org.example;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


public class MyTestHandler extends AbstractHandler {

    @Override
    public void handle(String string, Request baserequest, HttpServletRequest hsr, HttpServletResponse response) throws IOException, ServletException {
        // response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // response status code - sende alles ok an Client
        response.setStatus(HttpServletResponse.SC_OK);

        System.out.println("method :" + hsr.getMethod());  //welche methode - POST oder GET
        System.out.println("pathinfo " + hsr.getPathInfo()); //verzeichnis Pfad abz�glich Context
        System.out.println("context " + hsr.getContextPath()); // in welchen Context bewegen wir uns
    
        // POST Variablen namen ausgeben
    
        Enumeration<String> list = hsr.getParameterNames();
        while (list.hasMoreElements()) {
            String postname = list.nextElement(); //variablenname
            String postvalue = hsr.getParameter(postname); //inhalt der Variable
            System.out.println("var " + postname + " value " + postvalue); //ausgabe auf Console
        }

        // Write response: hier ein kleines Eingabeformular f�r den Client f�r den Anfang
        response.getWriter().println("<h1>Hello World</h1><form action=\"/test/return.html\" method=\"post\" > ");
        response.getWriter().println("<input type=\"text\" name=\"return\" /> ");
        response.getWriter().println("</form>");

        // Sage dem Server das die Anfrage abgearbeitet wurde - sprich wenn weitere Handler noch in der Liste sind
        // die werden nicht mehr gebraucht
        baserequest.setHandled(true);

    }

}
