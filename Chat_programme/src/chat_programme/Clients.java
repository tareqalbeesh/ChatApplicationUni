/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_programme;

import java.io.*;
import java.util.ArrayList;


public class Clients implements Serializable{
    
    private ArrayList <Client> q = new ArrayList() ;
    
    void Add (Client client){
        q.add(client);
    }
    
    ArrayList <Client> getList (){ 
        return q ;
    }
}
