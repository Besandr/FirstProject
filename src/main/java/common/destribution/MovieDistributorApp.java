package common.destribution;

import utils.IOHelper;

import java.util.HashMap;

public class MovieDistributorApp {

    public static void main(String[] args) {
        new MovieDistributorApp().go();
    }

    public void go(){

        Catalogue catalogue = new Catalogue();

        AbstractDistributor distributor = offerMovie(catalogue);

        Client client = new Client(distributor);
        client.watchMovie();
    }

    AbstractDistributor offerMovie(Catalogue catalogue){

        IOHelper ioHelper = new IOHelper(System.in, System.out);
        AppHelper appHelper = new AppHelper();

        HashMap<Languages, String> movieTitle = appHelper.movieChoosing(catalogue, ioHelper);

        Languages language = appHelper.languageChoosing(ioHelper);

        return AbstractDistributor.createDistributor(movieTitle, language);
    }

}
