/*
 * @Author Daemon Macklin
 * Class for Activity Object
 */
package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Activity {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private String name;
    private LocalDate dateStarted;
    private LocalDate finishDate;
    private String description;
    private Boolean isFinished;

    /**
     * Constructor for Activity class
     * @param name Name of activity
     * @param finishDate Date the Activity is to be finished
     * @param description A short Description of the activity
     */
    public Activity(String name, LocalDate finishDate, String description){
        this.setName(name);
        LocalDate now = LocalDate.now();
        this.setDateStarted(now);
        this.setFinishDate(finishDate);
        this.setDescription(description);
        this.setFinished(false);
    }

    /**
     * Setters and Getters
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 30) {
            int maxLength = (description.length() < 40)?description.length():30;
            description = description.substring(0, maxLength);
            this.description = description;
        } else {
            this.description = description;
        }
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 30) {
            int maxLength = (name.length() < 30)?name.length():30;
            name = name.substring(0, maxLength);
            this.name = name;
        } else {
            this.name = name;
        }
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
