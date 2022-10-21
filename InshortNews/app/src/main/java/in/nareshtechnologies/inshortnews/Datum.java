
package in.nareshtechnologies.inshortnews;

import java.io.Serializable;

public class Datum implements Serializable {

    public String author;
    public String content;
    public String date;
    public String id;
    public String imageUrl;
    public String readMoreUrl;
    public String time;
    public String title;
    public String url;

    public Datum(String author, String content, String date, String id, String imageUrl, String readMoreUrl, String time, String title, String url) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.id = id;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
        this.time = time;
        this.title = title;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getReadMoreUrl() {
        return readMoreUrl;
    }

    public void setReadMoreUrl(String readMoreUrl) {
        this.readMoreUrl = readMoreUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
