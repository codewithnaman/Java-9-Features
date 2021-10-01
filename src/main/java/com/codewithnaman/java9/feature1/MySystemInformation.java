package com.codewithnaman.java9.feature1;

public class MySystemInformation implements FindSystemInformation {
    public static void main(String[] args) {
        MySystemInformation mySystemInformation = new MySystemInformation();
        //Number Of CPU are : 8
        System.out.println("Number Of CPU are : " + mySystemInformation.numbersOfThreadsAvailable());
        //Total JVM Memory is : 260
        System.out.println("Total JVM Memory is : "+ mySystemInformation.totalMemory());
    }
}
