/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deom;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axa
 */
class Read extends Thread {
    private  Socket client;

    Read(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run () {
        DataInputStream read = null;
        try {
            read = new DataInputStream (client.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(read.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
