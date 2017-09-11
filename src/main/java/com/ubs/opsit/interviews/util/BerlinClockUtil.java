package com.ubs.opsit.interviews.util;

import com.ubs.opsit.interviews.model.LampColor;

import java.util.List;
import java.util.stream.Collectors;

public class BerlinClockUtil {

    private static List<String> clockRows;

    public static void setClockWithDefaultLamps(List<String> defaultRows){
        clockRows = defaultRows;
    }

    public static List<String> getClockWithLampsUpdatedEquivalentToTime() {
        return clockRows;
    }

    public static void litLampsInaRowAndUpdateInBerlinClock(int noOfLampsToLit, int rowNumber, LampColor lampColor) {
        String lampsInaRow = clockRows.get(rowNumber-1);
        for(int i = 0 ; i < noOfLampsToLit ; i++){
            lampsInaRow = changeLampColor(lampsInaRow, i, lampColor);
        }
        if(rowNumber == 4){lampsInaRow = lampsInaRow.replaceAll("YYY","YYR");}

        updateRowInBerlinClock(rowNumber, lampsInaRow);
    }

    private static String changeLampColor(String lampsInaRow, int lampPositionToChangeColor, LampColor lampColor) {
        return lampsInaRow.replaceFirst(String.valueOf(lampsInaRow.charAt(lampPositionToChangeColor)), lampColor.toString());
    }

    private static void updateRowInBerlinClock(int rowNumber, String lampsInaRow) {
        clockRows.remove(rowNumber-1);
        clockRows.add(rowNumber-1,lampsInaRow);
    }

    public static String getBerlinClockTimeInStringFormat(List<String> berlinClock) {
        String lineSeparator = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                berlinClock.stream().map($ -> String.valueOf($)).collect(Collectors.joining(lineSeparator))
        );

        return stringBuilder.toString();
    }

}
