package common.destribution;

import java.util.HashMap;

class UkrainianDistributor extends AbstractDistributor {


    UkrainianDistributor(HashMap<Languages, String> movieTitle) {
        super(movieTitle);
    }

    @Override
    Movie createMovie() {
        return new RussianMovie(movieTitle.get(Languages.UKRAINIAN));
    }

    @Override
    Subtitles createSubtitles() {
        return new UkrainianSubtitles();
    }
}
