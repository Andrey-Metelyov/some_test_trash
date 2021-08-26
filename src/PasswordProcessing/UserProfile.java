package PasswordProcessing;

import java.io.*;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private final String login;
    private final String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(encrypt(password));
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        String password = (String) stream.readObject();
        this.password = decrypt(password);
    }

    private String encrypt(String string) {
        System.out.println("encrypt " + string);
        char[] arr = string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
        return String.valueOf(arr);
    }

    private String decrypt(String string) {
        System.out.println("decrypt " + string);
        char[] arr = string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i]--;
        }
        return String.valueOf(arr);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        UserProfile vasya = new UserProfile("Vasya", "vasya@mail", "vaso");
        UserProfile petya = new UserProfile("Petya", "petya@mail", "pedro");
        System.out.println(vasya);
        System.out.println(petya);
        try {
            FileOutputStream fos = new FileOutputStream("tmp.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vasya);
            oos.writeObject(petya);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("tmp.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            UserProfile newVasya = (UserProfile) ois.readObject();
            UserProfile newPetya = (UserProfile) ois.readObject();
            ois.close();
            System.out.println(newVasya);
            System.out.println(newPetya);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
