package by.epam.jwd.bean;

public enum Status {
	ONLINE("Online"),
    OFFLINE("Offline");

    private String status;

    Status() {
    }

    Status(String status) {
        this.status = status;
    }

    public String getTitle() {
        return status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName()).concat(" - status : ").concat(status).concat("]"));

        return sb.toString();
    }
}
