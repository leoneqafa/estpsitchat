/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticlient;

/**
 *
 * @author informatica
 */
public class Chatmulticlient 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        clientchatjava clientchatjava = new clientchatjava();
        clientchatjava.connetti();
        clientchatjava.comunica();
        clientchatjava2 clientchatjava2 = new clientchatjava2();
        clientchatjava2.connetti2();
        clientchatjava2.comunica2();
        
    }
    