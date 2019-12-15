package by.javatr.task1.util;

public class Hello {

    public String message(String userName){
        StringBuilder sb = new StringBuilder("Hello, ");

        if (userName != null && !userName.isEmpty()){
            sb.append(userName);
        }else {
            sb.append("anon");
        }

        return sb.toString();
    }
}
