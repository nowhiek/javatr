package by.javatr.library.entity;

import java.io.Serializable;

public class User implements Cloneable {
    private long idUser;
    private String nameUser;
    private String passwordUser;
    private Role roleUser;

    public User() {
    }

    public User(long idUser, String nameUser, String passwordUser, Role roleUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Role getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Role roleUser) {
        this.roleUser = roleUser;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User clone = (User) super.clone();

        return clone;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = (int) (idUser + (nameUser == null ? 0 : nameUser.hashCode()));
        result = result * prime + (passwordUser == null ? 0 : passwordUser.hashCode());
        result = result * prime + (roleUser == null ? 0 : roleUser.hashCode());

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

        User tmp = (User) obj;

        if (idUser != tmp.idUser)
            return false;
        if (nameUser == null){
            if (tmp.nameUser != null)
                return false;
        }else if (!nameUser.equals(tmp.nameUser)){
            return false;
        }
        if (passwordUser == null){
            if (tmp.passwordUser != null)
                return false;
        }else if (!passwordUser.equals(tmp.passwordUser)){
            return false;
        }
        if (roleUser.getTitle() == null){
            if (tmp.roleUser.getTitle() != null)
                return false;
        }else if (!roleUser.getTitle().equals(tmp.roleUser.getTitle())){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName() + " - \n"));
        if (nameUser != null && !nameUser.isEmpty()){
            sb.append("\tId : ".concat(String.valueOf(idUser)).concat("\n"));
            sb.append("\tLogin : ".concat(nameUser).concat("\n"));
            sb.append("\tPassword : ".concat(passwordUser).concat("\n"));
            sb.append("\tRole : ".concat(roleUser.getTitle()).concat("\n"));
        }else{
            sb.append("\tempty\n");
        }

        sb.append("]");

        return sb.toString();
    }
}
