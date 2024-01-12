
package chat_programme;

import java.net.*;


public class LiveClient {
    private String userName ; 
    private Socket client ; 
    
    LiveClient (String userName , Socket client){
        this.userName = userName;
        this.client = client ; 
    }
    
    Socket getClient (){
        return client;
    }
}
