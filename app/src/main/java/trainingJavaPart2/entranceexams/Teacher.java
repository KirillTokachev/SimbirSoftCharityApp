package trainingJavaPart2.entranceexams;

import java.util.Objects;

public class Teacher {

    private String username;

    public Teacher(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Teacher teacher = (Teacher) obj;

        return Objects.equals(username, teacher.username);
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

}
