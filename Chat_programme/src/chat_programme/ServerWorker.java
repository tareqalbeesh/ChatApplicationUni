/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_programme;

import java.net.Socket;


class ServerWorker extends Thread {

    
    private Socket client ; 
    
    ServerWorker(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run (){
        
        
    }
}
