/*
 * @Author Daemon Macklin
 * Class for User Object
 */

package sample;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Activity> ToDoList;

    /**
     * Constructor for User class
     * @param name Name of user
     * @param password users password
     */
    public User(String name, String password){
        this.setName(name);
        this.setPassword(password);
        this.ToDoList = new ArrayList<>();
    }

    /**
     * Setters and Getters
     */
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.replaceAll("\\s+","");
    }

    public ArrayList<Activity> getToDoList() {
        return ToDoList;
    }
}
