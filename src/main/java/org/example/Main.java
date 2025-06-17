package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. Creates users and adds them to an array. (this seems more suited to an arraylist tbh)
key phrase that made me choose arraylist over an array for users: "adds"
which tells me "number of users may be 0, may be 5, may be 100, don't know how many"
2. Adds tasks to users' to-do lists.
3. Marks tasks as completed.
4. Prints all tasks for each user.
*/
public class Main {
    public static void loggedOutMenu(){
        System.out.println("TO-DO LIST SYSTEM");
        System.out.println("0. Exit");
        System.out.println("1. Create User");
        System.out.println("2. Log In as User");
        System.out.println("3. View Menu");
    }

    public static void loggedInMenu(String userName){
        System.out.println("Logged in as " + userName);
        System.out.println("0. Log Out");
        System.out.println("1. View All Tasks");
        System.out.println("2. Add New Task");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. View Menu");
    }

    public static User userSystem(User user, Scanner scanner){
        int choice = -1;

        System.out.println(user);
        System.out.println();
        loggedInMenu(user.getUserName());
        while (choice != 0) {
            System.out.print("Enter your choice:");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                switch (choice){
                    case 0: {
                        System.out.println("Logging out...");
                        break;
                    }
                    case 1: {
                        System.out.println(user);
                        break;
                    }
                    case 2: {
                        scanner.next();
                        String description;

                        while (true){
                            System.out.print("Enter a task (or \"end\" to exit): ");
                            description = scanner.nextLine();
                            if (description.equalsIgnoreCase("end")){
                                break;
                            } else if (description.isEmpty()){
                                System.out.println("ERR: Task is empty.");
                            } else {
                                user.addTask(new Task(description));
                                System.out.println("Task added.");
                                break;
                            }
                        }
                    }
                    case 3: {
                        System.out.println(user);
                        int taskIndex;
                        while (true){
                            System.out.print("Enter a task ID to set it to Done (or -1 to exit): ");
                            if (scanner.hasNextInt()){
                                taskIndex = scanner.nextInt();
                                if (taskIndex == -1){
                                    break;
                                }
                                user.setAsComplete(taskIndex);
                                break;
                            } else {
                                System.out.println("ERR: Invalid input.");
                            }
                        }
                    }
                    case 4: {
                        loggedInMenu(user.getUserName());
                        break;
                    }
                    default: {
                        System.out.println("ERR: Invalid choice.");
                        loggedInMenu(user.getUserName());
                    }
                }
            } else {
                System.out.println("ERR: Please enter an integer.");
            }
        }
        return user;
    }

    public static boolean userIsUnique(String userName, ArrayList<User> userArray){
        for (int i = 0; i < userArray.size(); i++) {
            if (userArray.get(i).getUserName().equals(userName)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<User> userArray = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        loggedOutMenu();
        while (choice != 0) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                switch (choice) {
                    case 0: {
                        System.out.println("Exiting program...");
                        break;
                    }
                    case 1: {
                        scanner.next();
                        boolean isEnd;
                        String userName;
                        String firstTask;

                        System.out.println("Create User selected.");
                        while (true) {
                            System.out.print("Enter username (or \"end\" to exit): ");
                            userName = scanner.nextLine();
                            userName = userName.trim();
                            if (!userName.isEmpty() && userIsUnique(userName, userArray)){
                                break;
                            } else {
                                System.out.println("ERR: Username already taken OR Username is empty.");
                            }
                        }
                        isEnd = userName.equalsIgnoreCase("end");
                        while (!isEnd){
                            System.out.print("Enter your first task: ");
                            firstTask = scanner.nextLine();
                            firstTask = firstTask.trim();
                            if (!firstTask.isEmpty()){
                                userArray.add(new User(userName, new Task(firstTask)));
                                System.out.println("User added.");
                                isEnd = false;
                            } else {
                                System.out.println("ERR: Task text is empty.");
                            }
                        }
                        break;
                    }
                    case 2: {
                        scanner.next();
                        String userName;
                        User user;

                        System.out.println("Log In selected.");
                        while (true) {
                            System.out.println("Enter username (or \"end\" to exit): ");
                            userName = scanner.nextLine();
                            if (userName.equalsIgnoreCase("end")){
                                break;
                            }
                            if (userName.isEmpty()){
                                System.out.println("ERR: Username is empty.");
                            } else {
                                for (int i = 0; i <= userArray.size(); i++) {
                                    if (i == userArray.size()){
                                        System.out.println("ERR: User not found.");
                                        break;
                                    }
                                    if (userArray.get(i).getUserName().equals(userName)){
                                        user = userSystem(userArray.get(i), scanner);
                                        userArray.set(i, user);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        loggedOutMenu();
                        break;
                    }
                    default: {
                        System.out.println("ERR: Invalid choice.");
                        loggedOutMenu();
                    }
                }
            } else {
                System.out.println("ERR: Please enter an integer.");
            }
        }
    }
}