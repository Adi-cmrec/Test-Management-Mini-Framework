package framework;

public class ConfigManager {
    private static ConfigManager instance;
    private String baseUrl;

    private ConfigManager() {
        // Private constructor to prevent instantiation
        this.baseUrl = "http://localhost:8080/api"; // Default base URL
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}