/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_programme;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axa
 */
class SendMessage extends Thread{

    DataInputStream read ;
    Socket client;
    private  Socket client2;
    
    SendMessage(DataInputStream read, Socket client, ArrayList<LiveClient> q) {
        this.read = read ; 
        this.client = client ;
        this.client2 = q.get(0).getClient();
    }
    
    public void run () {
       
        try {
            send();
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void send() throws IOException {
        DataOutputStream out = new DataOutputStream(client2.getOutputStream());
        out.writeUTF(read.readUTF());
    }

    
}
