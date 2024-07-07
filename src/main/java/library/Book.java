package library;

public class Book {
    private String title;
    private String author;
    private boolean isLent;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isLent = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }
}
