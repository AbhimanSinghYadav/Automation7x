package com.thetestingacademy;

public class Builderpatternjava {
    //change return type of each method as class type
    //"this" always points to current/calling object.Returning the same to
    //have same reference
    public Builderpatternjava Floor1(){
        System.out.println("stage 1 is done");
        return this;
    }
    public Builderpatternjava Floor2(String param){
        System.out.println("stage 1 is done");
        return this;
    }
    public Builderpatternjava Floor3(){
        System.out.println("stage 1 is done");
        return this;
    }

    public static void main(String[] args) {
        Builderpatternjava bp=new Builderpatternjava();
        bp.Floor1().Floor2("abhiman").Floor3();
        

    }
}
