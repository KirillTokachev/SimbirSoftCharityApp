package trainingJavaPart2;

public class Time {

    private int hours, minutes, seconds;
    public Time(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }
    public Time() {
        this(0, 0, 0);
    }
    public void setHours(int h) {
        if (h < 0 || h > 23){
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        } else {
            hours = h;
        }
    }
    public void setMinutes(int m) {
        if (m < 0 || m > 59) {
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        } else {
            minutes = m;
        }
    }
    public void setSeconds(int s) {
        if (s < 0 || s > 59) {
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        } else {
            seconds = s;
        }
    }
    public int hours() {
        return hours;
    }
    public int minutes() {
        return minutes;
    }
    public int seconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void addSeconds(int s) {
        seconds += s;
        minutes += seconds / 60;
        seconds = seconds % 60;
        hours += minutes / 60;
        minutes = minutes % 60;
        hours = hours % 24;
    }
    public void addMinutes(int m) {
        addSeconds(m * 60);
    }
    public void addHours(int h) {
        addSeconds(h * 60 * 60);
    }

}
