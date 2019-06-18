package common.destribution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Catalogue {

    private List<HashMap<Languages, String>> moviesTitles;

    Catalogue(){
        init();
    }

    private void init(){

        moviesTitles = new ArrayList<>();

        HashMap<Languages, String> aladdin = new HashMap<>();
        aladdin.put(Languages.UKRAINIAN, "\"Аладдін\"");
        aladdin.put(Languages.RUSSIAN, "\"Аладдин\"");
        aladdin.put(Languages.ENGLISH, "\"Aladdin\"");

        addMovieToCatalogue(aladdin);

        HashMap<Languages, String> avengers = new HashMap<>();
        avengers.put(Languages.ENGLISH, "\"Avengers: Endgame\"");
        avengers.put(Languages.RUSSIAN, "\"Мстители: Финал\"");
        avengers.put(Languages.UKRAINIAN, "\"Месники: Завершення\"");

        addMovieToCatalogue(avengers);

        HashMap<Languages, String> johnWick = new HashMap<>();
        johnWick.put(Languages.ENGLISH, "\"John Wick: Chapter 3 - Parabellum\"");
        johnWick.put(Languages.UKRAINIAN, "\"Джон Уік 3\"");
        johnWick.put(Languages.RUSSIAN, "\"Джон Уик 3\"");

        addMovieToCatalogue(johnWick);
    }

    void addMovieToCatalogue(HashMap<Languages, String> movie) {
        moviesTitles.add(movie);
    }

     List<HashMap<Languages, String>> getMoviesTitles() {
        return moviesTitles;
    }
}
