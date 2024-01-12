
package chat_programme;

import java.io.DataInputStream;
import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


class AddClient extends Thread {
    
    DataInputStream read ;
    Socket client ;
    ArrayList <Client> q ;
    Clients c ; 
    AddClient(DataInputStream read, Socket client) {
        this.read = read ; 
        this.client = client ;
    }
    
    @Override
    public void run () {
        String Email="" ;
        int password =0;
        
 try {
     
            Email = read.readUTF();
            password = read.readInt();
            
            
 } catch (IOException ex) { Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);}
        
 
        boolean check=true;

        try {
            check = BinarySearch(Email);//////////
            
        } catch (IOException ex) {
            Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        
        
//try {
//            
//            new DataOutputStream (client.getOutputStream()).writeBoolean(check);///////
//        
//} catch (IOException ex) {Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);}
            
        if (check) try {
            AddNewClient(Email ,password);
        } catch (IOException ex) {
            Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private boolean BinarySearch(String Email) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream ("Clients.txt");
        ObjectInputStream in = new ObjectInputStream (f);
         c = (Clients) in.readObject();
        q = c.getList();
        if (q.size()!=0){
            for (int  i=0 ;i<q.size() ;i++)
            {
                 if (q.get(i).getUserName().equals(Email))
                     return false ;
            }
        }
        
        return true;
            
    }

    private void AddNewClient(String Email, int password) throws FileNotFoundException, IOException {
        
        q.add(new Client (password ,Email));
        FileOutputStream f = new FileOutputStream ("Clients.txt");
        ObjectOutputStream out  = new ObjectOutputStream (f);
        out.writeObject(c);
    }
}
