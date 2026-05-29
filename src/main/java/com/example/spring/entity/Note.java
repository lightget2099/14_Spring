package com.example.spring.entity;

public class Note {
    private long id;
    private String title;
    private String content;

    public Note() { }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }
}
