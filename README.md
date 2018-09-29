# What Next?
 What next is a small To-Do application that will allow users to keep on track of their lives. 
Hello Red Hat!

## Background
I will be developing this app in Java as it is what I am more comfortable with it
and I am not very interested in Web Development. I understand the key concepts of 
RESTful but I believe a CRUD application will demonstrate the same 
concepts and fundamentals. It is planned to be a JavaFX application. 
It is simple to use, just log in or sign up and view your to do list 
and the different activities on it, Or add new ones.

## Running the Application
The application has been exported to a .jar file. To run the application you must have
Java installed and ensure both WhatNext.jar and xstream-1.4.10.jar are in the same
directory. Then simply run the WhatNext.jar file by clicking on it or running the command:
```console
User@RedHat:~$ java -jar WhatNext.jar
```

## Storing Data
I shall be using XML to store the User data. The user data includes a name and password,
along with all of their Activates that need to be done.

## Activity
The Activity object will be the things that the user needs to do. It has a name, a short
description and the start and finish date.

## Authentication 
For my project I am using a simple method for user authentication. My method is not
secure as the passwords are saved in plain text in the xml file. But this functionality
of having multiple users is still there.

## JavaFX
I decided to use JavaFx as the GUI cause  but I felt that JavaFX would be a good way to 
showcase my abilaties.
 
## Adding new Activities
By imputing the relevant information into the text boxes under Add activity and pressing
the add Task button, the information will be taken from the text boxes and used to 
create a new Activity object which is added to an arraylist used to represent the to do
list stored in the User object. 

## Viewing Activities
When signed in, clicking on the drop down menu will allow you to select any one of the 
users activities. After selecting the desired activity You can then press the view button
this will display all the Activities data by getting the name of the selected activity
and searching though the users activity list. 

## Removing and Updating an Activity
When viewing a Activity it will be possible to either remove or Mark the activity as
done by simply pressing the button. When removing the activity is simply removed from 
the users to do arraylist and Java handles the rest. When Marking an activity as read
the programme changes the isFinished variable from false to true. 

## Data Structure
The Data structure uses a simple ArrayList to store Users. The activates are stored
in each users Object along with their other information. This makes it easy to access
the Users to do list and also ensure other users don't have access to another users
to do list. The only way to access a users data is to be signed in, or by manually
reading the XML file.   


