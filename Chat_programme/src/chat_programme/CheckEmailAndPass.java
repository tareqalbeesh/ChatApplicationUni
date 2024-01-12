/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_programme;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


class CheckEmailAndPass extends Thread{
    
    DataInputStream read;
            Socket client;
    
    CheckEmailAndPass(DataInputStream read, Socket client) {
        
        this.read = read ; 
        this.client = client  ;
    }

   
    
    public void run (){
    
        String Email ="";
        int password =0;
        
        try {
            Email = read.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(CheckEmailAndPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            password = read.readInt();
        } catch (IOException ex) {
            Logger.getLogger(CheckEmailAndPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                new DataOutputStream (client.getOutputStream()).writeInt(email_Pass(Email,password));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CheckEmailAndPass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckEmailAndPass.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                    } catch (IOException ex) {
            Logger.getLogger(CheckEmailAndPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    int email_Pass (String Email , int password ) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream f = new FileInputStream ("Clients.txt");
        ObjectInputStream in = new ObjectInputStream (f);
        Clients c = (Clients) in.readObject();
        int u =0;
        for (int i=0 ;i<c.getList().size() ; i++){
            if (c.getList().get(i).getUserName().equals(Email))
            {
                u=1; if (c.getList().get(i).getPassword()!=password) return 2; // password is wrong
            }
        }
        if (u==0) return 1 ; // Email is Wrong
        return 0 ; // both are true 
    }
}
