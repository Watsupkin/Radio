package domain;

public class Radio {
    private int currentStation;
    private int volume;

    public int getCurrentStation() {

        return currentStation;
    }

    public int getVolume() {
        return volume;
    }

    public int setStation(int newCurrentStation) {
        if (newCurrentStation > 9) {
            currentStation = 0;
        }
        if (newCurrentStation < 0) {
            currentStation = 9;
        } else {
            currentStation = newCurrentStation;
        }
        return currentStation;
    }

    public int next() {

        return currentStation = (currentStation >= 9) ? 0 : (currentStation + 1);
    }

    public int prev() {

        return currentStation = (currentStation <= 0) ? 9 : (currentStation - 1);
    }

    public int setVolume(int newVolume) {
        if (newVolume > 10) {
            volume = 10;
        }
        if (newVolume < 0) {
            volume = 0;
        } else {
            volume = newVolume;
        }
        return volume;
    }

    public int plusVolume() {
        return volume = (volume >= 10) ? 10 : (volume += 1);
    }

    public int minusVolume() {
        return volume = (volume <= 0) ? 0 : (volume -= 1);
    }


}