package sample;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.thoughtworks.xstream.XStream;
import javafx.scene.text.Text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Controller {

    @FXML
    private TextField nameText;
    @FXML
    private Text UserInfo;
    @FXML
    private PasswordField passwordText;

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
            return null;
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
    public void displayData(){
        UserInfo.setText("Logged in as: " + currentUser.getName());

    }
}
