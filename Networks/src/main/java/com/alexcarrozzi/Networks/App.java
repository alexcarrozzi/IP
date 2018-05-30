package com.alexcarrozzi.Networks;

import java.net.UnknownHostException;
import java.util.Random;

public class App{
    public static void main( String[] args ){
    	CIDRUtils cidrUtils = null;
    	String cidr = "192.168.0.1/1";
    	
    	try {
			cidrUtils = new CIDRUtils(cidr);		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	
		String networkAddress = cidrUtils.getNetworkAddress();
		String broadcastAddress = cidrUtils.getBroadcastAddress();	   	
    	
		System.out.println("CIDR Input: "+cidr);
    	
        DottedDecimal networkObj = new DottedDecimal(networkAddress);
        System.out.println("Network Address: "+networkObj.getAddress());        

        DottedDecimal broadcastObj = new DottedDecimal(broadcastAddress);
        System.out.println("Broadcast Address: "+broadcastObj.getAddress());
        
        //Create 10 random IP addresses and check if they are in range of our network
    	Random rand = new Random();
    	DottedDecimal temp = null;
        for(int i=0; i<10; i++) {   
        	int pos[] = new int[4];
        	
        	for(int j=0; j<3; j++) {
        		pos[j] = rand.nextInt(255);
        	}
        	int tempCidr = rand.nextInt(32);
        	
        	temp = new DottedDecimal(pos);
        	
        	System.out.println("Checking if "+temp.getAddress()+" is in range...");
        	try {
				System.out.println(cidrUtils.isInRange(temp.getAddress()));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
        }
    }
}
