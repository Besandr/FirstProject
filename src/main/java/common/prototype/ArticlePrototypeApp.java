package common.prototype;

import utils.IOHelper;
import utils.UserInteractingHelper;

import java.util.List;

public class ArticlePrototypeApp {

    public static void main(String[] args) {
        new ArticlePrototypeApp().go();
    }

    public void go(){

        IOHelper ioHelper = new IOHelper(System.in, System.out);
        UserInteractingHelper userInteractingHelper = new UserInteractingHelper(ioHelper);
        Librarian librarian = new Librarian();


        for (int k = 0; k < 2; k++) {

            ioHelper.print("Choose article for editing");

            List<String> articleTitles = librarian.getArticleTitles();
            for (int i = 0; i < articleTitles.size(); i++) {
                ioHelper.print(i + 1 + ". " + articleTitles.get(i));
            }

            int articleIndex = userInteractingHelper.takeUserChoice(1, articleTitles.size()) - 1;
            Article editingArticle = librarian.getArticleByIndex(articleIndex);

            ioHelper.print("You've chosen an article: " + editingArticle.getTitle());
            ioHelper.print("Content:");
            ioHelper.print(editingArticle.getContent());
            ioHelper.print("");

            String newContent = ioHelper.input("Enter edited content:");
            editingArticle.setContent(newContent);

            if (librarian.replaceArticle(editingArticle)){
                ioHelper.print("Article has edited successfully");
            } else {
                ioHelper.print("Article hasn't edited");
            }
        }
    }
}
