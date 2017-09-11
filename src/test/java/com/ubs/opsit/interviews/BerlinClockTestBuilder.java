package com.ubs.opsit.interviews;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BerlinClockTestBuilder {

    private List<String> berlinClock;

    public BerlinClockTestBuilder(){
        berlinClock = new LinkedList<>();
    }

    public List<String> getBerlinClock() {
        return berlinClock;
    }

    public BerlinClockTestBuilder with(String lamps){
        berlinClock.add(lamps);
        return this;
    }

    public String build(){
        String lineSeparator = System.getProperty("line.separator");
        String berlinClockStr = berlinClock.stream().collect(Collectors.joining(lineSeparator));
        return berlinClockStr;
    }


}
