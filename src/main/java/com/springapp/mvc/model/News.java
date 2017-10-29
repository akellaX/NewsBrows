package com.springapp.mvc.model;

import javax.persistence.*;
@Entity
@Table(name="news_table")
public class News {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name="content")
    private String content;
    @Column(name="category")
    private String category;
    @Column(name="date")
    private String date;
    @Column(name="title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getID() {

        return ID;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "News{" +
                "ID=" + ID +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
