package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Member> memberList;

    public Library() {
        bookList = new ArrayList<>();
        memberList = new ArrayList<>();
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void removeBook(Book book){
        bookList.remove(book);
    }

    public void registerMember(Member member){
        memberList.add(member);
    }

    public boolean lendBook(Book book, Member member){
        if(bookList.contains(book) && !book.isLent()){
            book.setLent(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book, Member member){
        if(bookList.contains(book) && book.isLent()){
            book.setLent(false);
            return true;
        }
        return false;
    }

    public List<Book> getBooks(){
        return bookList;
    }

    public List<Member> getMembers(){
        return memberList;
    }
}
