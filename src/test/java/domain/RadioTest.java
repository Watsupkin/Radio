package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {


    @ParameterizedTest
    @CsvSource(value ={"lowLimit,0,0","underLowLimit,-1,9","aboveLowLimit,1,1","upperLimit,9,9","underUpperLimit,8,8","aboveUpperLimit,10,0"})
    void shouldSetStation(String testName, int newCurrentStation, int expected) {
        Radio pioneer = new Radio();
        int actual = pioneer.setStation(newCurrentStation);
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value ={"limitValue,9,0",/*"aboveLimitValue,10,0",*/"underLimitValue,8,9"})
    void shouldNext(String testName, int newCurrentStation, int expected) {
        Radio pioneer = new Radio();
        pioneer.setStation(newCurrentStation);
        int actual = pioneer.next();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value ={"limitValue,0,9","aboveLimitValue,1,0",/*"underLimitValue,-1,9"*/})
    void shouldPrev(String testName, int newCurrentStation, int expected) {
        Radio pioneer = new Radio();
        pioneer.setStation(newCurrentStation);
        int actual = pioneer.prev();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value ={"lowLimit,0,0","underLowLimit,-1,0","aboveLowLimit,1,1","upperLimit,10,10","underUpperLimit,9,9","aboveUpperLimit,11,10"})
    void sholdSetVolume(String testName, int newVolume, int expected) {
        Radio pioneer = new Radio();
        int actual = pioneer.setVolume (newVolume);
        assertEquals(expected, actual);
    }
    @Test
    void plusVolume() {
    }
    @ParameterizedTest
    @CsvSource(value ={"limitValue,10,10","aboveLimitValue,11,10","underLimitValue,8,9"})
    void shouldPlusVolume(String testName, int newVolume, int expected) {
        Radio pioneer = new Radio();
        pioneer.setVolume(newVolume);
        int actual = pioneer.plusVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value ={"limitValue,0,0","aboveLimitValue,2,1","underLimitValue,-1,0"})
    void shouldMinusVolume(String testName, int newVolume, int expected) {
        Radio pioneer = new Radio();
        pioneer.setVolume(newVolume);
        int actual = pioneer.minusVolume();
        assertEquals(expected, actual);
    }
}