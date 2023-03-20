package com.example.film001;


import javax.persistence.*;

@Entity
@Table(name = "films")

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "rating")
    private String rating;

    @Column(name = "comment")
    private String comment;

    public int getId() {
        return id;
    }

    public Film() {
    }

    public Film(String name, int year, String rating, String comment) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.comment = comment;
    }

    public Film(int id, String name, int year, String rating, String comment) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rating='" + rating + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
