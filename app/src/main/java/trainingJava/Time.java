package trainingJava;

public class Time {

    private int hours, minutes, second;
    public Time(int hours, int minutes, int second) {
        setHours(hours);
        setMinutes(minutes);
        setSecond(second);
    }
    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }
    public Time() {
        this(0, 0, 0);
    }
    public void setHours(int h) {
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        else
            hours = h;
    }
    public void setMinutes(int m) {
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        else
            minutes = m;
    }
    public void setSecond(int s) {
        if (s < 0 || s > 59)
            throw new IllegalArgumentException("Введенно некоретктрное значние");
        else
            second = s;
    }
    public int hours() {
        return hours;
    }
    public int minutes() {
        return minutes;
    }
    public int seconds() {
        return second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, second);
    }

    public void addSeconds(int s) {
        second += s;
        minutes += second / 60;
        second = second % 60;
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
