package by.epam.jwd.dao.connectionpool;

public enum ConnectionParametr {
	DRIVER("db.driver"),
	URL("db.url"),
	USER("db.user"),
	PASSWORD("db.password"),
	POOL_SIZE("db.pool_size");
	
	private String key;

	ConnectionParametr(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
