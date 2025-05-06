package utils;

public class TimeUtil {
    /**
     * This method will make wait for 1 second.
     */
    public static void miniWait(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will make wait for 3 seconds.
     */
    public static void tooShortWait(){
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will make wait for 5 seconds.
     */
    public static void shortWait(){
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will make wait for 10 seconds.
     */
    public static void mediumWait(){
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
