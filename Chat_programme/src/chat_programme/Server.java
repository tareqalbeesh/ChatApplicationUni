
package chat_programme;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    
    static  ArrayList <LiveClient> q = new ArrayList ();
    
    public static void main (String[] args) throws IOException{
        
        ServerSocket server = new ServerSocket (123);
        
        while (true){
            
            Socket client = server.accept();
        
            
            DataInputStream read = new DataInputStream (client.getInputStream());
            int u = read.readInt();
            if (u==-1){
                LiveClient g = new LiveClient("Abed",client);
                 q.add(g);
//                AddClient a = new AddClient (read,client);
//                a.start();
            }
            else if (u==-2){
                
                CheckEmailAndPass c = new CheckEmailAndPass(read,client);
                c.start();
            }
            else if (u==1){
                
                SendMessage s = new SendMessage (read,client,q); s.start();
            }    
          }
    }
}
