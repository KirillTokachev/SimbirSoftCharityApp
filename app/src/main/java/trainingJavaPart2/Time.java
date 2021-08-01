package trainingJavaPart2;

public class Time {

    private final int MIN = 60;
    private final int HOUR = 24;

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
        if (h < 0 || h > HOUR-1){
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        } else {
            hours = h;
        }
    }
    public void setMinutes(int m) {
        if (m < 0 || m > MIN-1) {
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        } else {
            minutes = m;
        }
    }
    public void setSeconds(int s) {
        if (s < 0 || s > MIN-1) {
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
        minutes += seconds / MIN;
        seconds = seconds % MIN;
        hours += minutes / MIN;
        minutes = minutes % MIN;
        hours = hours % HOUR;
    }
    public void addMinutes(int m) {
        addSeconds(m * MIN);
    }
    public void addHours(int h) {
        addSeconds(h * MIN * MIN);
    }

}
