package energy.dubhacks.reliefApp.model;


import java.util.List;
import java.util.Map;

public class Post {
    private String summary;
    private String originalMessage;
    private Map<String, List<String>> categoriesToTags;
    private boolean urgent;

    public Post(String summary, String originalMessage, Map<String, List<String>> categoriesToTags, boolean urgent) {
        this.summary = summary;
        this.originalMessage = originalMessage;
        this.categoriesToTags = categoriesToTags;
        this.urgent = urgent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    public Map<String, List<String>> getCategoriesToTags() {
        return categoriesToTags;
    }

    public void setCategoriesToTags(Map<String, List<String>> categoriesToTags) {
        this.categoriesToTags = categoriesToTags;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}
