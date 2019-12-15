package by.javatr.task4.entity;

public class User {
    private String userName;
    private Password password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public User(String userName, Password password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        User tmp = (User)obj;

        if (userName == null){
            if (tmp.userName != null)
                return false;
        }else if (!userName.equals(tmp.userName)){
            return false;
        }
        if (password == null){
            if (tmp.password != null)
                return false;
        }else if (!password.equals(tmp.password)){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "[User - " + userName + " : " + password.getPassword() + "]";
    }
}
