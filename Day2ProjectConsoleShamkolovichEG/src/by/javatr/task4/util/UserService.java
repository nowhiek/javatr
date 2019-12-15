package by.javatr.task4.util;

import by.javatr.task4.entity.Password;
import by.javatr.task4.entity.User;

public class UserService {

    public boolean isPasswordEquals(User user, Password checkedPassword){
        if (!user.getPassword().equals(checkedPassword))
            return false;

        return true;
    }
}
