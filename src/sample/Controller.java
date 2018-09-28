package sample;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Controller {

    @FXML
    private TextField nameText, passwordText;

    private ArrayList<User> users = new ArrayList<>();

    public void addUser(ActionEvent actionEvent) {
        String name = nameText.getText();
        String password = passwordText.getText();
        User newUser = new User(name, password);
        users.add(newUser);
        saveUserData();
    }

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

    public void loadUserData(){
        try {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("users.xml"));
            users = (ArrayList<User>) is.readObject();
            is.close();
        }catch (Exception e){
            System.out.println("Error Loading Data" + e);
        }
    }
}
