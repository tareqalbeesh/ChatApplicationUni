
package chat_programme;

import java.io.*;
import java.net.Socket;


public class Chat_programme {

    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
       
            
        
        
            Socket client = new Socket ("127.0.0.1",123);
            
            DataOutputStream out = new DataOutputStream (client.getOutputStream());
            out.writeInt(1);
            out.writeUTF("Alzoubi");
            
            
        
    }
    
}
