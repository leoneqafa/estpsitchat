/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticlient;
import java.io.*;
import java.net.*;

/**
 *
 * @author informatica
 */
public class clientchatjava2
{
    String nome_server="127.0.0.1";
    int porta_server=7777;
    Socket socket;
    BufferedReader input_tastiera;
    String messaggio;
    String risposta;
    DataOutputStream dati_al_server;
    BufferedReader dati_dal_server;
    
    public Socket connetti2(){
        System.out.println("alla ricerca di un utente");
        try {
            System.out.println("inserire nome");
            input_tastiera=new BufferedReader(new InputStreamReader(System.in));
            socket=new Socket(nome_server,porta_server);
            dati_al_server=new DataOutputStream(socket.getOutputStream());
            dati_dal_server=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(UnknownHostException e){
            System.err.println("Host non riconosciuto.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione.");
            System.exit(1);
        }
        return(socket);
    }
    public void comunica2(){
        try {
            System.out.println("inserisci nome");
            messaggio=input_tastiera.readLine();
            System.out.println("Invio in corso");
            dati_al_server.writeBytes(messaggio+'\n');
            risposta=dati_dal_server.readLine();
            System.out.println("Risposta del server: "+risposta);
            System.out.println("Chiusura dell'esecuzione.");
            socket.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server.");
            System.exit(1);
        }
    }
}