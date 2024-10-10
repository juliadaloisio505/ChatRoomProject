import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerInputThread extends Thread{
 
    private Socket clientSocket;
    private String userName;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PINK = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public void run(){
	try{
	    BufferedReader stdIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    userName = stdIn.readLine();
	    ChatServer.messages.add(ANSI_CYAN + userName + " has joined the chat!" + ANSI_RESET);
	    ChatServer.connections.add(clientSocket);
	    

	    String inputLine = stdIn.readLine();
	    while(inputLine != null){
		String toBeAdded = ANSI_PINK + userName + ": " + ANSI_RESET;
		String toAddOn = ANSI_BLUE + inputLine + ANSI_RESET;
		ChatServer.messages.add(toBeAdded + toAddOn);
		inputLine = stdIn.readLine();
	    }
	    //Read in a line representing the username
	    //Set the username field
	    //Add a new socket to the static connection list

	    //Continually read input from the client socket
	    //Add that input to the messages list with the username infront "JR: lorum ipsum"
	}catch(Exception e){
	    System.out.println("ServerInputThread (run): " + e);
	    System.exit(1);
	}
    }

    public ServerInputThread(Socket clientSocket){
	try{
	    this.clientSocket = clientSocket; 
	}catch(Exception e){
	    System.out.println("ServerInputThread (Constructor)"+e);
	    System.exit(1);
	}
    }
}
