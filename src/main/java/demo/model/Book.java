package demo.model;

import java.io.Serializable;

/**
 * Created by AnLu on
 * 2017/7/14 11:00.
 * JavaEE_Framework
 */
public class Book implements Serializable{
    private Integer id;
    private String title;
    private String author;
    private String date;
    private Double price;

    public Book() {
    }

    public Book(Integer id,String title, String author, String date, Double price) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
