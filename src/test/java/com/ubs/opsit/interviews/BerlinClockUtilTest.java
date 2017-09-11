package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.model.BerlinClock;
import com.ubs.opsit.interviews.model.LampColor;
import com.ubs.opsit.interviews.util.BerlinClockUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockUtilTest {


    @Before
    public void setUp(){
        BerlinClockUtil.setClockWithDefaultLamps(new BerlinClock().getDefaultClock());
    }

    @Test
    public void shouldReturnDefaultClockValuesSetWhenCheckedUsingGetterAfterSetupMethodIsCalled(){
        //Given
        //defined in setUp method


        //When
        List<String> berlinClock = BerlinClockUtil.getClockWithLampsUpdatedEquivalentToTime();

        //Then
        assertThat(berlinClock.get(0)).isEqualTo("O");
        assertThat(berlinClock.get(3)).isEqualTo("OOOOOOOOOOO");

    }

    @Test
    public void shouldLightTheLampOfFirstHrsRowWhenRowNumberIs2(){
        //Given

        //defined in setUp method

        //When
        BerlinClockUtil.litLampsInaRowOfBerlinClock(2,2, LampColor.RED);
        List<String> berlinClock = BerlinClockUtil.getClockWithLampsUpdatedEquivalentToTime();

        //Then
        assertThat(berlinClock.get(1)).isEqualTo("RROO");
        assertThat(berlinClock.get(3)).isEqualTo("OOOOOOOOOOO");
    }

    @Test
    public void shouldLightTheLampOfFirstMinutesRowInYYRFormatWhenRowNumberIs4AndNoOfLampsToLightIs5(){
        //Given

        //defined in setUp method

        //When
        BerlinClockUtil.litLampsInaRowOfBerlinClock(5,4, LampColor.YELLOW);
        List<String> berlinClock = BerlinClockUtil.getClockWithLampsUpdatedEquivalentToTime();

        //Then
        assertThat(berlinClock.get(3)).isEqualTo("YYRYYOOOOOO");
        assertThat(berlinClock.get(2)).isEqualTo("OOOO");
    }

    @Test
    public void shouldReturnBerlinClockTimeInStringFormatWhenListHavingBerlinClockRowsIsPassed(){
        //Given

        BerlinClockTestBuilder berlinClockTestBuilder = new BerlinClockTestBuilder()
                .with("Y")
                .with("RRRO")
                .with("RROO")
                .with("YYROOOOOOOO")
                .with("YYYY");
        List<String> berlinClock = berlinClockTestBuilder.getBerlinClock();

        String expectedBerlinClockStr = berlinClockTestBuilder.build();

        //When
        String actualBerlinClockStr = BerlinClockUtil.getBerlinClockTimeInStringFormat(berlinClock);

        //Then
        assertThat(actualBerlinClockStr).isEqualTo(expectedBerlinClockStr);
    }



}
