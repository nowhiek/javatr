package by.epam.jwd.bean;

import java.io.Serializable;

public final class User implements Serializable {
	
	private static final long serialVersionUID = 182481293213L;
	
	private String userName;
	private String userPassword;
	private String userEmail;
	private Role userRole;
	private Status userStatus;
	private boolean isBanned;
	
	public User() {}
	
	public User(String name, String password, String email, Role role, Status status, boolean ban) {
		this.userName = name;
		this.userPassword = password;
		this.userEmail = email;
		this.userRole = role;
		this.userStatus = status;
		this.isBanned = ban;
	}
	
	public final void setUserName(String name) {
		this.userName = name;
	}
	
	public final String getUserName() {
		return userName;
	}
	
	public final void setUserPassword(String password) {
		this.userPassword = password;
	}
	
	public final String getUserPassword() {
		return userPassword;
	}
	
	public final void setUserEmail(String email) {
		this.userEmail = email;
	}
	
	public final String getUserEmail() {
		return userEmail;
	}
	
	public final void setUserRole(Role role) {
		this.userRole = role;
	}
	
	public final Role getUserRole() {
		return userRole;
	}
	
	public final void setUserStatus(Status status) {
		this.userStatus = status;
	}
	
	public final Status getUserStatus() {
		return userStatus;
	}
	
	public final void setUserBan(boolean ban) {
		this.isBanned = ban;
	}
	
	public final boolean getUserIsBanned() {
		return isBanned;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName() + " - \n"));
        if (userName != null && !userName.isEmpty()){
            sb.append("\tLogin : ".concat(userName).concat("\n"));
            sb.append("\tPassword : ".concat(userPassword).concat("\n"));
            sb.append("\tEmail : ".concat(userEmail).concat("\n"));
            sb.append("\tRole : ".concat(userRole.getTitle()).concat("\n"));
            sb.append("\tStatus : ".concat(userStatus.getTitle()).concat("\n"));
            sb.append("\tBanned : ".concat(String.valueOf(isBanned)).concat("\n"));
        }else{
            sb.append("\tempty\n");
        }

        sb.append("]");

        return sb.toString();
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		
		result = result * prime  + (userName == null ? 0 : userName.hashCode());
		result = result * prime + (userPassword == null ? 0 : userPassword.hashCode());
		result = result * prime + (userEmail == null ? 0 : userEmail.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		User tmp = (User) obj;
		
		if (userName == null) {
			if (tmp.userName != null) {
				return false;
			}
		}else if (!userName.equals(tmp.userName)) {
			return false;
		}
		
		if (userPassword == null) {
			if (tmp.userPassword != null) {
				return false;
			}
		}else if (!userPassword.equals(tmp.userPassword)) {
			return false;
		}
		
		if (userEmail == null) {
			if (tmp.userEmail != null) {
				return false;
			}
		}else if (!userEmail.equals(tmp.userEmail)) {
			return false;
		}
		
		if (userRole.getTitle() == null) {
			if (tmp.userRole.getTitle() != null) {
				return false;
			}
		}else if (!userRole.getTitle().equals(tmp.userRole.getTitle())) {
			return false;
		}
		
		if (userStatus.getTitle() == null) {
			if (tmp.userStatus.getTitle() != null) {
				return false;
			}
		}else if (!userStatus.getTitle().equals(tmp.userStatus.getTitle())) {
			return false;
		}
		
		if (isBanned != tmp.isBanned) {
			return false;
		}
		
		return true;
	}
}
