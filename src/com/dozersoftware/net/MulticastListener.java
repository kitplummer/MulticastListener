package com.dozersoftware.net;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MulticastSocket s;
	    InetAddress group;
	    
	    System.out.println("Listening for messages...");
	    try {
	    	group = InetAddress.getByName("224.0.0.6");
			s = new MulticastSocket(6789);
			s.setLoopbackMode(true);
			s.joinGroup(group);
			byte[] buffer = new byte[10 * 1024];
		    DatagramPacket data = new DatagramPacket(buffer, buffer.length);
		    
			while(true){
				s.receive(data);
		        String txt = new String(buffer, 0, data.getLength());
		        System.out.println("RXED: " + txt);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
