package nz.ac.auckland.se281;

public class Profile{
    private String username;
    private String age;

    public Profile(String username, String age){

        this.username = username;
        this.age = age;
    }


    public String getUsername() {
        return this.username;

    }

    public String getAge(){
        return this.age;
    }
    
}