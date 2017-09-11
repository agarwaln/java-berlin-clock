package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.model.BerlinClock;
import com.ubs.opsit.interviews.model.LampColor;
import com.ubs.opsit.interviews.util.BerlinClockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeConverterImpl implements TimeConverter{

    private static Logger logger = LoggerFactory.getLogger(TimeConverterImpl.class);

    public static final String INVALID_INPUT = "Time provided is not in valid. Please enter valid value";
    private int hrs;
    private int minutes;
    private int seconds;

    @Override
    public String convertTime(String aTime) {
        logger.info(String.format("Starting time conversion for [%s] ",aTime));

        validateAndSplitTimeIntoParts(aTime);


        BerlinClockUtil.setClockWithDefaultLamps(new BerlinClock().getDefaultClock());

        BerlinClockUtil.litLampsInaRowAndUpdateInBerlinClock(checkAndGetWhetherToLitLampInSecondsRow(seconds), 1, LampColor.YELLOW);
        BerlinClockUtil.litLampsInaRowAndUpdateInBerlinClock(hrs/5, 2, LampColor.RED);
        BerlinClockUtil.litLampsInaRowAndUpdateInBerlinClock(hrs % 5, 3, LampColor.RED);
        BerlinClockUtil.litLampsInaRowAndUpdateInBerlinClock(minutes/5, 4, LampColor.YELLOW);
        BerlinClockUtil.litLampsInaRowAndUpdateInBerlinClock(minutes % 5, 5, LampColor.YELLOW);

        String berlinClockTimeStr = BerlinClockUtil.getBerlinClockTimeInStringFormat(BerlinClockUtil.getClockWithLampsUpdatedEquivalentToTime());
        logger.info(String.format("Conversion completed!! Berlin clock time equaivalent to [%s] is [%s]",aTime, berlinClockTimeStr));

        return berlinClockTimeStr;

    }

    private void validateAndSplitTimeIntoParts(String aTime) {
        String[] timeParts = aTime.split(":");
        try {
            hrs = Integer.parseInt(timeParts[0]);
            minutes = Integer.parseInt(timeParts[1]);
            seconds = Integer.parseInt(timeParts[2]);
        } catch (IllegalArgumentException e) {
            logger.error(String.format("Error occurred while parsing time [%s] as one of part is not in valid format",aTime));
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        if (!(hrs >= 0 && hrs <= 24) ||
                !(minutes >= 0 && minutes <= 60) ||
                !(seconds >= 0 && seconds <= 60)) {
            logger.error(String.format("Error occurred for [%s] as one of part is not with in ideal range",aTime));
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private int checkAndGetWhetherToLitLampInSecondsRow(int seconds) {
        int noOfLampsToLitInSecondsRow = 0;
        if(seconds%2 == 0){
            noOfLampsToLitInSecondsRow = 1;
        }
        return noOfLampsToLitInSecondsRow;
    }


}
