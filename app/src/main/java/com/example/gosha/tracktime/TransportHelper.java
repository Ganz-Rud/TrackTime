package com.example.gosha.tracktime;

/**
 * Created by gosha on 12.07.2016.
 */
public class TransportHelper {

    int transport;

    public void setTransport(int temp){
        transport = temp;
    }

    public String getNameTransport(){
        String text = "";
        switch (transport){
            case 11111:
                text = "Автобус";
                System.out.print(text);
                break;
            case 22222:
                text = "Тролейбус";
                System.out.print(text);
                break;
            case 33333:
                text = "Трамвай";
                System.out.print(text);
                break;
            case 44444:
                text = "Метро";
                System.out.print(text);
                break;
        }
        return text;
    }



}
