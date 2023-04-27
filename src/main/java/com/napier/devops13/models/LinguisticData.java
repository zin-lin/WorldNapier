package com.napier.devops13.models;

public class LinguisticData {

    private String language;
    private double percentage;

    /**
     * get language
     * @return
     */
    public String getLanguage() {
        return language;
    }

    /**
     * language setter
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * get percentage
     * @return
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * percentage setter
     * @param percentage
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Linguistic Data Constructor
     * @param language
     * @param percentage
     */
    public LinguisticData(String language, double percentage) {
        this.language = language;
        this.percentage = percentage;
    }

}
