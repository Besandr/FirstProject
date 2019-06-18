package common.destribution;

import java.util.HashMap;

class RussianDistributor extends AbstractDistributor {

    RussianDistributor(HashMap<Languages, String> movieTitle) {
        super(movieTitle);
    }

    @Override
    Movie createMovie() {
        return new RussianMovie(movieTitle.get(Languages.RUSSIAN));
    }

    @Override
    Subtitles createSubtitles() {
        return new RussianSubtitles();
    }
}
