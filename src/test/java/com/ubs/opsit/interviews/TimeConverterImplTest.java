package com.ubs.opsit.interviews;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeConverterImplTest {
    private TimeConverter timeConverter;

    @Before
    public void setUp(){
        timeConverter = new TimeConverterImpl();
    }


    @Test
    public void shouldReturnEquivalentBerlinClockTimeForaTime17Hrs12Mins0Secs(){
        //Given
        String aTime = "17:12:00";
        String expectedBerlinClockTimeStr = new BerlinClockTestBuilder()
                .with("Y")
                .with("RRRO")
                .with("RROO")
                .with("YYOOOOOOOOO")
                .with("YYOO")
                .build();

        //When
        String actualBerlinClockTime = timeConverter.convertTime(aTime);

        //Then
        assertThat(actualBerlinClockTime).isEqualTo(expectedBerlinClockTimeStr);
    }

    @Test
    public void shouldReturnEquivalentBerlinClockTimeForMidNight(){
        //Given
        String aTime = "00:00:00";

        String expectedBerlinClockTimeStr = new BerlinClockTestBuilder()
                .with("Y")
                .with("OOOO")
                .with("OOOO")
                .with("OOOOOOOOOOO")
                .with("OOOO")
                .build();

        //When
        String actualBerlinClockTime = timeConverter.convertTime(aTime);

        //Then
        assertThat(actualBerlinClockTime).isEqualTo(expectedBerlinClockTimeStr);
    }

    @Test
    public void shouldThrowIllegalArgumentsExceptionWhenTimePassedIsNotNumber(){
        //Given
        String aTime = "ee:00:00";

        //When
        try {
            timeConverter.convertTime(aTime);
        }catch (IllegalArgumentException e){
            //Then
            assertThat(e.getMessage()).isEqualTo(TimeConverterImpl.INVALID_INPUT);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentsExceptionWhenTimePassedIsNotWithinTimeRange(){
        //Given
        String aTime = "22:101:20";

        //When
            timeConverter.convertTime(aTime);
    }



}
