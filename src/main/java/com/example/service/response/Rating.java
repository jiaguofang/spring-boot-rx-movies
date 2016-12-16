package com.example.service.response;

/**
 * @author Jiaguo Fang
 */
public class Rating {
    
    private String id;
    
    private Double average;
    
    private Integer numRaters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(Integer numRaters) {
        this.numRaters = numRaters;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id='" + id + '\'' +
                ", average=" + average +
                ", numRaters=" + numRaters +
                '}';
    }
}
