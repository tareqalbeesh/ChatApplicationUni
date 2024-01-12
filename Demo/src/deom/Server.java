/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deom;

import java.io.*;
import java.io.IOException;
import java.net.*;


public class Server {
    
     public static void main(String[] args) throws IOException{
         ServerSocket server = new ServerSocket (123);
         
         while (true){
             Socket client = server.accept();
             
             DataInputStream in = new DataInputStream (client.getInputStream());
             int number = in.readInt();
             if (number ==1 ){
                 
             }
         }
     }
}
