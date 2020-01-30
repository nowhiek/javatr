package by.javatr.library.bean;

import java.io.Serializable;

public class Author implements Cloneable, Serializable {
    private String authorFirstName;
    private String authorSecondName;


    public Author() {
    }

    public Author(String authorFirstName, String authorSecondName) {
        this.authorFirstName = authorFirstName;
        this.authorSecondName = authorSecondName;
    }

    public final String getAuthorFirstName() {
        return authorFirstName;
    }

    public final void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public final String getAuthorSecondName() {
        return authorSecondName;
    }

    public final void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    @Override
    public Author clone() throws CloneNotSupportedException {
        Author clone = (Author) super.clone();

        return clone;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + (authorFirstName == null ? 0 : authorFirstName.hashCode()) + (authorSecondName == null ? 0 : authorSecondName.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Author tmp = (Author) obj;

        if (authorFirstName == null){
            if (tmp.authorFirstName != null)
                return false;
        }else if (!authorFirstName.equals(tmp.authorFirstName)){
            return false;
        }
        if (authorSecondName == null){
            if (tmp.authorSecondName != null)
                return false;
        }else if (!authorSecondName.equals(tmp.authorSecondName)){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName().concat(" - ")));
        if (authorFirstName != null || !authorFirstName.isEmpty()){
            sb.append(authorFirstName.concat(" ").concat(authorSecondName));
        }else{
            sb.append(getClass().getName().concat(" - empty"));
        }

        sb.append("]");

        return sb.toString();
    }
}
