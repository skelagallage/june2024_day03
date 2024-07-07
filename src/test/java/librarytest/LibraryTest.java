package librarytest;

import library.Book;
import library.Library;
import library.Member;
import org.testng.Assert;
import org.testng.annotations.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Member member1;
    private Member member2;

    @DataProvider(name = "bookProvider")
    public Object[][] bookProvider(){
        return new Object[][]{
                {new Book("Book3", "Author3")},
                {new Book("Book4", "Author4")},
                {new Book("Book5", "Author5")}
        };
    }

    @BeforeClass
    public void setupLibrary(){
        library = new Library();
    }

    @BeforeMethod
    public void setupBooksAndMembers(){
        book1 = new Book("Book1", "Author1");
        book2 = new Book("Book2", "Author2");
        member1 = new Member("Member1");
        member2 = new Member("Member2");
        library.addBook(book1);
        library.addBook(book2);
        library.registerMember(member1);
        library.registerMember(member2);
    }

    @AfterMethod
    public void clearBooksAndMembers(){
        library.getBooks().clear();
        library.getMembers().clear();
    }

    @AfterClass
    public void makeLibraryNull(){
        library = null;
    }

    @Test(groups = "addRemoveBook")
    public void testAddBook(){
        Book book6 = new Book("Book6", "Author6");
        library.addBook(book6);
        Assert.assertTrue(library.getBooks().contains(book6));
    }

    @Test(groups = "addRemoveBook")
    public void testRemoveBook(){
        library.removeBook(book1);
        Assert.assertFalse(library.getBooks().contains(book1));
    }
}


