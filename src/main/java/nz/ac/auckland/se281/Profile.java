package nz.ac.auckland.se281;

public class Profile{
    private String username;
    private int age;

    public Profile(String username, int age){

        this.username = username;
        this.age = age;
    }


    public String getUsername() {
        return this.username;

    }

    public int getAge(){
        return this.age;
    }
    
}