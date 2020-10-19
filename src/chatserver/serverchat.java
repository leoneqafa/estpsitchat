/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author informatica
 */
public class serverchat 
{
    ServerSocket socket_server=null;
    Socket socket_client=null;
    Socket socket_client2=null;
    String messaggio_client=null;
    String risposta_server=null;
    BufferedReader dati_dal_client;
    DataOutputStream dati_al_client;
    public Socket attendi()
    {
        try 
        {
            System.out.println("Server in esecuzione.");
            socket_server=new ServerSocket(8888);
            System.out.println("Server in attesa del primo client.");
            socket_client=socket_server.accept();
            System.out.println("Primo utente connesso.");
            System.out.println("Server in attesa del secondo client.");
            socket_client2=socket_server.accept();
            System.out.println("Secondo utente connesso.");
            dati_dal_client=new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            dati_al_client=new DataOutputStream(socket_client.getOutputStream());
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            System.out.println("Errore nell'istanziamento del server.");
            System.exit(1);
        }
        return(socket_client);
    }
    public void comunica()
    {
        try {
            System.out.println("In attesa del messaggio da parte del client.");
            messaggio_client=dati_dal_client.readLine();
            System.out.println("Messaggio ricevuto.");
            risposta_server=messaggio_client.toUpperCase();
            System.out.println("Invio della risposta al client.");
            dati_al_client.writeBytes(risposta_server+'\n');
            System.out.println("Elaborazione completata.");
            socket_client.close();
        }
        catch (Exception e) {
            System.out.println("Errore durante la comunicazione.");
        }
    }
}