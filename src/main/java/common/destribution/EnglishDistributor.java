package common.destribution;

import java.util.HashMap;

class EnglishDistributor extends AbstractDistributor {


    EnglishDistributor(HashMap<Languages, String> movieTitle) {
        super(movieTitle);
    }

    @Override
    Movie createMovie() {
        return new RussianMovie(movieTitle.get(Languages.ENGLISH));
    }

    @Override
    Subtitles createSubtitles() {
        return new EnglishSubtitles();
    }
}
