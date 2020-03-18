package by.epam.jwd.bean;

public enum Role {
	USER("User"),
    ADMIN("Admin");

    private String role;

    Role() {
    }

    Role(String role) {
        this.role = role;
    }

    public String getTitle() {
        return role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName()).concat(" - role : ").concat(role).concat("]"));

        return sb.toString();
    }
}
