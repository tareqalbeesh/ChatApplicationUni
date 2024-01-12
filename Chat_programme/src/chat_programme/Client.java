/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_programme;

import java.io.IOException;
import java.io.*;
import java.net.*;


public class Client implements Serializable {
    
   private int password ; 
   private String userName ; 
   
   

    Client(int password, String Email) {
       this.password = password ;
       this.userName = Email ;
    }
    
   String getUserName (){
       return userName ; 
   }
   
   int  getPassword (){
       return password ;
   }
   
}
