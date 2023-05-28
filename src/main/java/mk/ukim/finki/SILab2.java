package mk.ukim.finki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {//1
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //2
            throw new RuntimeException("Mandatory information missing!"); //3
        }

        if (user.getUsername()==null){ //4
            user.setUsername(user.getEmail()); //5
        }

        int same = 1; //6
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {//7
            same = 0; //8
            for (int i=0;i<allUsers.size();i++) { //9.1 //9.2
                User existingUser = allUsers.get(i); //10
                if (existingUser.getEmail() == user.getEmail()) {//11
                    same += 1;//12
                }
                if (existingUser.getUsername() == user.getUsername()) {//13
                    same += 1;//14
                }
            }//9.3
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //15
        String password = user.getPassword(); //16
        String passwordLower = password.toLowerCase(); //17

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //18
            return false; //19
        }
        else {
            if (!passwordLower.contains(" ")) { //20
                for (int i = 0; i < specialCharacters.length(); i++) { //21.1 //21.2
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //22
                        return same == 0;//23
                    }
                }//21.3
            }
        }
        return false;//24
    }
}//25

