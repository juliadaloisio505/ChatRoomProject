import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerOutputThread extends Thread{
    public void run(){
	try{
	    while(true){
		String mssg = null;
		if(ChatServer.messages.size() != 0){
		    mssg = ChatServer.messages.get(0);
		}
		if(mssg != null){
		    for(Socket s : ChatServer.connections){
			PrintWriter socketOut = new PrintWriter(s.getOutputStream(), true);
			socketOut.println(mssg);
		    }
		    ChatServer.messages.pop();
		}
		else{
		    Thread.sleep(100);
		}
	    }
	    
		
		//get oldest message and iterate over clients and remove from messages arraylist
			   
	      
		
		    
	   
	    //Continually loop through all messages
	    //If queue is not empty then pop message off the queue
	    //Loop through all connections and send popped message to each connection

	   //Sleep for 100 miliseconds if the queue is currently empty   
	}catch(Exception e){
	    System.out.println("ServerOutputThread (run): " + e);
	}
    }
}
