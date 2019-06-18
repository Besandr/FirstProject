package common.destribution;

import java.util.HashMap;

public abstract class AbstractDistributor {

    HashMap<Languages, String> movieTitle;

    abstract Movie createMovie();
    abstract Subtitles createSubtitles();

    AbstractDistributor(HashMap<Languages, String> movieTitle){
        this.movieTitle = movieTitle;
    }

    static AbstractDistributor createDistributor(HashMap<Languages, String> movieTitle, Languages language) {

        switch (language) {
            case ENGLISH:
                return new EnglishDistributor(movieTitle);
            case RUSSIAN:
                return new RussianDistributor(movieTitle);
            case UKRAINIAN:
                return new UkrainianDistributor(movieTitle);
            default:
                throw new IllegalStateException("Unknown language");
        }
    }

}
