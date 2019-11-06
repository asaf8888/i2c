package com.company;

import javafx.util.Pair;

import java.nio.ByteBuffer;


public class Main {
    public static Pair<String, Double> byteToDouble(byte[] input) {

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (input[index] != 0) {
            sb.append((char) input[index]);
            index++;
        }
        String name = sb.toString();
        index++;
        double myDouble = ByteBuffer.wrap(input, index, 8).getDouble();
        Pair<String, Double> output = new Pair<>(name, myDouble);
        return (output);
    }

    public static String[] byteToString(byte[] input) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (input[index] != 0) {
            sb.append((char) input[index]);
            index++;
        }
        String name = sb.toString();
        index++;
        StringBuilder sb2 = new StringBuilder();
        while (input[index] != 0) {
            sb.append((char) input[index]);
            index++;
        }
        String value = sb.toString();
        String[] output = new String[2];
        output[0] = name;
        output[1] = value;
        return (output);
    }

    public static Pair<String, Boolean> byteToBoolean(byte[] input) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (input[index] != 0) {
            sb.append((char) input[index]);
            index++;
        }
        String name = sb.toString();
        index++;
        Boolean value = Boolean.TRUE;
        if ((int) input[index] == 0) {
            value = true;
        } else {
            value = false;
        }
        Pair<String, Boolean> output = new Pair<>(name, value);
        return (output);
    }
    public static byte[] doubleToByte(String stringinput, double doubleinput){
        byte[] output = new byte[9+stringinput.length()];
        int index=0;
        for(int i = 0; i < stringinput.length(); i++){
            output[i] = (byte)stringinput.charAt(i);
             index = i;
        }
        index++;
        output[index] = 0;
        index++;
        byte[] bb = new byte[8];
        ByteBuffer.wrap(bb).putDouble(doubleinput);
        for(int i = 0; i<8; i++){
            output[index+i] = bb[i];
        }
        return(output);
    }

    public static void main(String[] args) {
        double test1 = 8;
        String test2 = "test";
        byte[] test = doubleToByte(test2, test1);
        System.out.print(byteToDouble(test).getKey() + ": " + byteToDouble(test).getValue());

    }
}
