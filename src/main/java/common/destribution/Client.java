package common.destribution;

import utils.IOHelper;

class Client {

    private Movie concreteLanguageMovie;
    private Subtitles concreteLanguageSubtitles;

    Client(AbstractDistributor distributor) {

        concreteLanguageMovie = distributor.createMovie();
        concreteLanguageSubtitles = distributor.createSubtitles();

    }

    void watchMovie() {

        IOHelper helper = new IOHelper(System.in, System.out);

        String movieName = concreteLanguageMovie.getName();
        String subtitlesText = concreteLanguageSubtitles.getText();

        helper.print(movieName + subtitlesText);
    }

}
