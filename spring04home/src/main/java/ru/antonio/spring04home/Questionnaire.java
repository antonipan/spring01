package ru.antonio.spring04home;

public class Questionnaire {

    private Long id;
    private String name;
    private String author;
    private int quantityQuestions;
    private double shareCorrectAnsers;

    public Questionnaire(Long id, String name, String author, int quantityQuestions, double shareCorrectAnsers) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantityQuestions = quantityQuestions;
        this.shareCorrectAnsers = shareCorrectAnsers;
    }

    public Questionnaire(String name, String author, int quantityQuestions) {
        this.name = name;
        this.author = author;
        this.quantityQuestions = quantityQuestions;
    }

    public Questionnaire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantityQuestions() {
        return quantityQuestions;
    }

    public void setQuantityQuestions(int quantityQuestions) {
        this.quantityQuestions = quantityQuestions;
    }

    public double getShareCorrectAnsers() {
        return shareCorrectAnsers;
    }

    public void setShareCorrectAnsers(double shareCorrectAnsers) {
        this.shareCorrectAnsers = shareCorrectAnsers;
    }
}
