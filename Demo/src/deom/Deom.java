
package deom;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.*;
     
    public class Deom {
     
        public static void main(String[] args) throws IOException, InterruptedException {
            
            Socket client = new Socket ("127.0.0.1",123);
            
            DataOutputStream out = new DataOutputStream (client.getOutputStream());
            out.writeInt(-1);
//            out.writeUTF("Alzoubi");
//            out.writeInt(13);
            
            Read r = new Read (client); r.start();
            
        
        }
    
    }
