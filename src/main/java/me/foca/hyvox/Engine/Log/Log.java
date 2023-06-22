package me.foca.hyvox.Engine.Log;

public class Log {

    public static void error(Object message){
        System.out.println("[Hyvox] ERROR -> " + message);
    }

    public static void error(String message){
        System.out.println("[Hyvox] ERROR -> " + message);
    }

    public static void info(Object message){
        System.out.println("[Hyvox] INFO -> " + message);
    }

    public static void info(String message){
        System.out.println("[Hyvox] INFO -> " + message);
    }

    public static void debug(Object message){
        System.out.println("[Hyvox] DEBUG -> " + message);
    }

    public static void debug(String message){
        System.out.println("[Hyvox] DEBUG -> " + message);
    }

    public static void warn(Object message){
        System.out.println("[Hyvox] WARN -> " + message);
    }

    public static void warn(String message){
        System.out.println("[Hyvox] WARN -> " + message);
    }



}
