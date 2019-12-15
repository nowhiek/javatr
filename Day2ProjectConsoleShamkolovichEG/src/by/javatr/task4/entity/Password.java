package by.javatr.task4.entity;

public class Password {
    private String password;

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public Password(String password) {
        this.password = password;
    }

    public Password() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return  true;
        if (obj == null)
            return false;

        Password tmp = (Password)obj;

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
        return "[User - " + password + "]";
    }
}
