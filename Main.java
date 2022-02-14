package Joaircraft3;


import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {

        //Create radar target

        RadarTarget os811 = new RadarTarget("OS811",375, "B747-900");


        //Print current label

        System.out.println(os811.getLabel());
        System.out.println();


        //Change altitude command

        os811.changeAltitude(200);

        //Keep detecting target to see command executed

        for (int i = 0; i < 5; i++ )
        {

            sleep(1000);

            System.out.println(os811.getLabel());

            System.out.println();


        }




    }





}
