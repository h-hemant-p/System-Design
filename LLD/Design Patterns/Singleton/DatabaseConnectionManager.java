public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private ConnectionPool pool;

    private DatabaseConnectionManager() {
        pool = new ConnectionPool(); // Initialize pool
    }

    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return pool.getConnection();
    }
}