package org.example;

import java.io.*;
import java.util.*;

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class UserManager {
    private static final String USER_FILE = "users.txt";
    private Set<String> users;

    public UserManager() throws IOException {
        users = new HashSet<>();
        loadUsers();
    }

    private void loadUsers() throws IOException {
        File file = new File(USER_FILE);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
            reader.close();
        }
    }

    public boolean createUser(String username) throws IOException {
        if (users.contains(username)) {
            return false;
        } else {
            users.add(username);
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true));
            writer.write(username);
            writer.newLine();
            writer.close();
            return true;
        }
    }

    public boolean loginUser(String username) {
        return users.contains(username);
    }
}
