package com.example.service.response;

/**
 * @author Jiaguo Fang
 */
public class Review {
    
    private String id;
    
    private String author;
    
    private String summary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
