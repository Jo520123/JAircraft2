package Joaircraft3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Math.random;
import static java.lang.System.lineSeparator;
import static java.lang.System.out;
import static java.lang.Thread.sleep;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class RadarTarget {

    private String callSign;
    private int flightLevel;
    private int requiredFlightLevel;
    private String model;

    public RadarTarget(String callSign, int flightLevel, String model)
    {

        this.callSign = callSign;
        this.flightLevel = flightLevel;
        this.requiredFlightLevel = flightLevel;
        this.model = model;

    }

    public String getLabel()
    {
        StringBuilder a = new StringBuilder();

        a.append(this.callSign);
        a.append(lineSeparator());


        a.append(this.flightLevel)
                .append(this.getClimbDescendIndicator())
                .append(this.requiredFlightLevel);

        a.append(lineSeparator());

        a.append(model);

        return a.toString();


    }

    private String getClimbDescendIndicator()
    {
        if (this.requiredFlightLevel > this.flightLevel)
        {
            return "-UP-";

        }

        else if (this.requiredFlightLevel < this.flightLevel)
        {

            return "-DOWN-";

        }

        else {

            return "=EQUAL=";
        }

    }

    public void changeAltitude(int level)
    {
        out.println(this.callSign + " change altitude " + level);
        out.println();

        this.requiredFlightLevel = level;

        //Simulate long running operation


        ExecutorService b = newSingleThreadExecutor();

        b.execute(() -> {

            try{

                sleep((long)(random()*5*1000));

            } catch (InterruptedException ex){

                ex.printStackTrace();

            }

            this.flightLevel = requiredFlightLevel;

        });




    }


}

