package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Activity {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private String Name;
    private String dateStarted;
    private String finishDate;
    private String description;

    public Activity(String name, String finishDate, String description){
        this.setName(name);
        LocalDateTime now = LocalDateTime.now();
        this.setDateStarted(dtf.format(now));
        this.setFinishDate(finishDate);
        this.setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
