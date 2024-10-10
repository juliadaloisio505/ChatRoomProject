import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ChatServer{
    public static volatile ArrayList<Socket> connections = new ArrayList<>();
    public static volatile LinkedList<String> messages = new LinkedList<>();

    public static void main(String[] args){
	try{
	    //Fire up a ServerOutputThread
	    ServerOutputThread t1  = new ServerOutputThread();
	    t1.start();
	    
	    
	    //Instantiate a ServerSocket in the below try parenthesis
	    try(ServerSocket serverSocket = new ServerSocket()){
                //bind() the socket to null
		serverSocket.bind(null);
		System.out.println("Address: " + serverSocket.getInetAddress());
		System.out.println("Port: " + serverSocket.getLocalPort());
		//construct a while loop to continually accept sockets                                   
		while(true){
		    Socket clientSocket = serverSocket.accept();
		    System.out.println("A new user has connected from: " + clientSocket);
		    ServerInputThread clientThread = new ServerInputThread(clientSocket);
		    // connections.add(clientSocket);
		    clientThread.start();
		}

	       
	       
	      
	       
	    }catch(Exception e){
		System.out.println("ChatServer: "+e);
	    }
	}catch(Exception e){
	    System.out.println("ChatServer: "+e);
	}
    }

}
