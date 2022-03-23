package domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Radio {
    private int currentStation;
    private int volume;

    public Radio(int currentStation) {
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {

        return currentStation;
    }

    public int getVolume() {
        return volume;
    }

    public int setStation(int newCurrentStation) {
        if (newCurrentStation > 10) {
            currentStation = 0;
        } else if (newCurrentStation < 0) {
            currentStation = 10;
        } else {
            currentStation = newCurrentStation;
        }
        return currentStation;
    }

    public int next() {

        return currentStation = (currentStation >= 10) ? 0 : (currentStation += 1);
    }

    public int prev() {

        return currentStation = (currentStation <= 0) ? 10 : (currentStation -= 1);
    }

    public int setVolume(int newVolume) {
        if (newVolume > 100) {
            volume = 100;
        } else if (newVolume < 0) {
            volume = 0;
        } else {
            volume = newVolume;
        }
        return volume;
    }

    public int plusVolume() {
        return volume = (volume >= 100) ? 100 : (volume += 1);
    }

    public int minusVolume() {
        return volume = (volume <= 0) ? 0 : (volume -= 1);
    }


}