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

    public User(String name, String password){
        this.setName(name);
        this.setPassword(password);
        this.ToDoList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Activity> getToDoList() {
        return ToDoList;
    }
}
