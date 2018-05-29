package com.alexcarrozzi.Networks;

public class App{
    public static void main( String[] args ){
        IP myIP = new IP("192.168.0.1");
        System.out.println(myIP.getAddress());
    }
}
