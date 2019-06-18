package common.prototype;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarianTest {

    private Librarian librarian;

    @Before
    public void init(){
        librarian = new Librarian();
    }

    @Test
    public void replaceArticleShouldReturnTrue() {

        WikiArticle article = new WikiArticle("test", "text");

        librarian.addArticle(article);

        article.setContent("edited text");

        assertTrue(librarian.replaceArticle(article));
    }

    @Test
    public void replaceArticleShouldReturnFalse() {

        WikiArticle article = new WikiArticle("test", "text");

        librarian.addArticle(article);

        article = new WikiArticle("test2", "text");

        assertFalse(librarian.replaceArticle(article));
    }
}