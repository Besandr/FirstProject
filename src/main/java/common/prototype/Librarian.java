package common.prototype;

import java.util.ArrayList;
import java.util.List;

class Librarian {

    private List<Article> articles;

    Librarian() {
        init();
    }

    private void init(){

        articles = new ArrayList<>();

        articles.add(new WikiArticle("NPU", "The National Pedagogical Dragomanov University is a Ukrainian University in Kyiv, which has III-IV accreditation level. "));
        articles.add(new WikiArticle("Software design pattern", "In software engineering, a software design pattern is a general, reusable solution to a commonly occurring problem within a given context in software design."));
        articles.add(new WikiArticle("EPAM", "EPAM Systems, Inc., also known as EPAM, is a global provider of software engineering and IT consulting services "));

    }

    void addArticle(Article article) {
        articles.add(article);
    }

    boolean replaceArticle(Article article) {

        int index;

        if ((index = articles.indexOf(article)) >= 0) {
            articles.set(index, article);
            return true;
        } else {
            return false;
        }
    }

    Article getArticleByName(String articleName) {

        WikiArticle tempArticle = new WikiArticle(articleName, "");

        int articleIndex = articles.indexOf(tempArticle);

        return getArticleByIndex(articleIndex);
    }

    Article getArticleByIndex(int articleIndex) {

        Article articleForEditing = (Article) articles.get(articleIndex).clone();

        return articleForEditing;
    }

    List<String> getArticleTitles(){

        List<String> articleTitles = new ArrayList<>();

        articles.forEach(a -> articleTitles.add(a.getTitle()));

        return articleTitles;
    }

    public static void main(String[] args) {

        Librarian librarian = new Librarian();
        Article article = librarian.articles.get(0);

        System.out.println("Editing original article:");
        System.out.println("Original article title: " + article.title);
        article.title = "qwerty";
        System.out.println("Edited article title: " + article.title);
        System.out.println("Original article title after editing: " + librarian.articles.get(0).title);
        System.out.println("===================================");

        article = librarian.getArticleByName("EPAM");
        System.out.println("Editing cloned article:");
        System.out.println("Original article title: " + article.title);
        article.title = "qwerty";
        System.out.println("Edited article title: " + article.title);
        System.out.println("Original article title after editing: " + librarian.articles.get(2).title);
    }
}
