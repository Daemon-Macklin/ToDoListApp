package sample;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.thoughtworks.xstream.XStream;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    @FXML
    private TextField nameText, activityNameText;
    @FXML
    private TextArea descriptionText;
    @FXML
    private DatePicker finishDateText;
    @FXML
    private Text UserInfo, activityNameDisplay, StartDateDisplay, FinishDateDisplay, DescriptionDisplay, finishedDisplay;
    @FXML
    private PasswordField passwordText;
    @FXML
    private ChoiceBox todoList;


    private ArrayList<User> users = loadUserData();
    private User currentUser;

    /**
     * Function used to add a new user
     * @param actionEvent
     */
    public void addUser(ActionEvent actionEvent) {
        String name = nameText.getText();
        String password = passwordText.getText();
        User newUser = new User(name, password);
        users.add(newUser);
        saveUserData();
    }

    /**
     * Function to save the user data
     */
    @SuppressWarnings("Unchekced")
    public void saveUserData(){
        XStream xstream = new XStream(new DomDriver());
        try {
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
            out.writeObject(users);
            out.close();
        }catch(Exception e){
            System.out.println("Error Saving:" + e);
        }
    }

    /**
     * Function to load user data
     * @return an Arraylist containing all of the user data
     */
    public ArrayList<User> loadUserData(){
        try {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("users.xml"));
            ArrayList<User> users = (ArrayList<User>) is.readObject();
            is.close();
            return users;
        }catch (Exception e){
            System.out.println("Error Loading Data" + e);
            ArrayList<User> users = new ArrayList<>();
            return users;
        }
    }

    /**
     * Method for authentication
     * @param actionEvent
     */
    public void Login(ActionEvent actionEvent) {
        currentUser = null;
        String name = nameText.getText();
        String password = passwordText.getText();
        for(int i=0; i < users.size(); i +=1){
            if(users.get(i).getName().equals(name)){
                if(users.get(i).getPassword().equals(password)){
                    currentUser = users.get(i);
                    System.out.println("Login Successful");
                    clearDisplay();
                    displayData();
                }else{
                    System.out.println("Password Incorrect");
                }
            }
        }
            System.out.println("User not found");
    }

    /**
     * Method that will display all of the user data
     */
    public void displayData() {
        try {
            if (currentUser.getName() != null) {
                UserInfo.setText("Logged in as: " + currentUser.getName());
                displayAcivities();
            }
        } catch (Exception e) {
                UserInfo.setText("Login or signup to see data");
                clearDisplay();
        }
    }

    /**
     * Method to clear the display
     */
    public void clearDisplay(){
        ObservableList emptyList = FXCollections.observableArrayList();
        todoList.setItems(emptyList);
        activityNameDisplay.setText("");
        StartDateDisplay.setText("");
        FinishDateDisplay.setText("");
        finishedDisplay.setText("");
        DescriptionDisplay.setText("");
    }

    /**
     * Method used to add a task
     * @param actionEvent
     */
    public void addTask(ActionEvent actionEvent){
        String name = activityNameText.getText();
        String description = descriptionText.getText();
        LocalDate finish = finishDateText.getValue();
        Activity newActivity = new Activity(name, finish, description);
        currentUser.getToDoList().add(newActivity);
        saveUserData();
        activityNameText.setText("");
        finishDateText.setChronology(null);
        descriptionText.setText("");
        displayAcivities();
    }

    /**
     * Method used to display the different activities on the to do list
     */
    public void displayAcivities(){
        ArrayList<Activity> activityList = currentUser.getToDoList();
        ObservableList<String> doList = FXCollections.observableArrayList();
        for(int i = 0; i < activityList.size(); i+=1) {
            doList.add(activityList.get(i).getName());
        }
        todoList.setItems(doList);
    }

    /**
     * Method to display the activity information
     * @param actionEvent
     */
    public void viewActivity(ActionEvent actionEvent) {
        String name = todoList.getValue().toString();
        Activity activity = findActivityByName(name);
        if(activity != null){
            activityNameDisplay.setText("Name: "+activity.getName());
            DescriptionDisplay.setText("Description: "+activity.getDescription());
            StartDateDisplay.setText("Start Date: "+activity.getDateStarted().toString());
            FinishDateDisplay.setText("Finsh Date: "+activity.getFinishDate().toString());
            String str = "In Progress";
            if(activity.getFinished()){
                str = "Finished";
            }
            finishedDisplay.setText("Status: " + str);
        }
    }

    /**
     * Method to find an activity by it's name
     * @param name
     * @return
     */
    public Activity findActivityByName(String name){
        ArrayList<Activity> activities = currentUser.getToDoList();
        for(int i =0; i < activities.size(); i+=1){
            if(name.equals(activities.get(i).getName())){
                return activities.get(i);
            }
        }
        return null;
    }

    /**
     * Function to set a activity as finished
     * @param actionEvent
     */
    public void setAsDone(ActionEvent actionEvent) {
        String name = todoList.getValue().toString();
        Activity activity = findActivityByName(name);
        activity.setFinished(true);
        finishedDisplay.setText("Status: Finished");
        saveUserData();
        displayData();
    }

    /**
     * Activity to remove and activity
     * @param actionEvent
     */
    public void removeActivity(ActionEvent actionEvent) {
        String name = todoList.getValue().toString();
        Activity activity = findActivityByName(name);
        for(int i = 0; i < currentUser.getToDoList().size(); i+=1){
            if(currentUser.getToDoList().get(i).equals(activity)){
                currentUser.getToDoList().remove(i);
                break;
            }
        }
        saveUserData();
        clearDisplay();
        displayData();
    }

    /**
     * Method to log users out
     * @param actionEvent
     */
    public void logOut(ActionEvent actionEvent) {
        currentUser = null;
        nameText.setText("");
        passwordText.setText("");
        displayData();
    }
}
