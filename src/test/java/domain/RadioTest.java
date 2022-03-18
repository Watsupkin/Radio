package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio pioneer = new Radio();


    @ParameterizedTest
    @CsvSource(value ={"lowLimit,0,0","underLowLimit,-1,10","aboveLowLimit,1,1","upperLimit,10,10","underUpperLimit,9,9","aboveUpperLimit,11,0"})
    void shouldSetStation(String testName, int newCurrentStation, int expected) {

        int actual = pioneer.setStation(newCurrentStation);
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value ={"limitValue,10,0",/*"aboveLimitValue,10,0",*/"underLimitValue,9,10"})
    void shouldNext(String testName, int newCurrentStation, int expected) {

        pioneer.setStation(newCurrentStation);
        int actual = pioneer.next();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value ={"limitValue,0,10","aboveLimitValue,1,0",/*"underLimitValue,-1,9"*/})
    void shouldPrev(String testName, int newCurrentStation, int expected) {

        pioneer.setStation(newCurrentStation);
        int actual = pioneer.prev();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value ={"lowLimit,0,0","underLowLimit,-1,0","aboveLowLimit,1,1","upperLimit,100,100","underUpperLimit,99,99","aboveUpperLimit,101,100"})
    void shouldSetVolume(String testName, int newVolume, int expected) {

        int actual = pioneer.setVolume (newVolume);
        assertEquals(expected, actual);
    }
    @Test
    void plusVolume() {
    }
    @ParameterizedTest
    @CsvSource(value ={"limitValue,100,100","aboveLimitValue,101,100","underLimitValue,90,91"})
    void shouldPlusVolume(String testName, int newVolume, int expected) {

        pioneer.setVolume(newVolume);
        int actual = pioneer.plusVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value ={"limitValue,0,0","aboveLimitValue,2,1","underLimitValue,-1,0"})
    void shouldMinusVolume(String testName, int newVolume, int expected) {

        pioneer.setVolume(newVolume);
        int actual = pioneer.minusVolume();
        assertEquals(expected, actual);
    }
}