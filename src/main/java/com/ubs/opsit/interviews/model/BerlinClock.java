package com.ubs.opsit.interviews.model;

import java.util.LinkedList;
import java.util.List;

public class BerlinClock {
    private List<String> clockRows;

    public  List<String> getDefaultClock(){
        List<String> clockRows = new LinkedList<>();

        ClockRow clockRow = new ClockRow();
        clockRows.add(clockRow.getLampRowWithDefaultStatus(1 ));
        clockRows.add(clockRow.getLampRowWithDefaultStatus(2 ));
        clockRows.add(clockRow.getLampRowWithDefaultStatus(3));
        clockRows.add(clockRow.getLampRowWithDefaultStatus(4 ));
        clockRows.add(clockRow.getLampRowWithDefaultStatus(5 ));

        return clockRows;
    }

}

 class ClockRow {
    private String lampColor;

    public String getLampRowWithDefaultStatus(int rowNumber){

        String rowWithDefaultLampColor ="";
        switch (rowNumber){
            case 1:
                rowWithDefaultLampColor = "O" ;
                break;
            case 2:
                rowWithDefaultLampColor = "OOOO";
                break;
            case 3:
                rowWithDefaultLampColor = "OOOO";
                break;
            case 4:
                rowWithDefaultLampColor = "OOOOOOOOOOO";
                break;
            case 5:
                rowWithDefaultLampColor = "OOOO";
                break;
        }
        return  rowWithDefaultLampColor;
    }

}
