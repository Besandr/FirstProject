package common.destribution;

import utils.IOHelper;
import utils.UserInteractingHelper;

import java.util.HashMap;

class AppHelper {

    HashMap<Languages, String> movieChoosing(Catalogue catalogue, IOHelper ioHelper) {

        ioHelper.print("Choose a movie:");

        int counter = 1;
        for (HashMap<Languages, String> movie : catalogue.getMoviesTitles()) {
            ioHelper.inLinePrint(counter++ + ". ");
            movie.forEach((k,v) -> ioHelper.inLinePrint(v + "/"));
            ioHelper.print("");
        }

        UserInteractingHelper userInteractingHelper = new UserInteractingHelper(ioHelper);
        int movieID = userInteractingHelper.takeUserChoice(1, catalogue.getMoviesTitles().size()) - 1;

        return catalogue.getMoviesTitles().get(movieID);


//        while (true) {
//
//            String choice = ioHelper.input("Enter your choice: ");
//
//            try {
//                int movieID = Integer.parseInt(choice) - 1;
//
//                if (movieID >= 0 && movieID < catalogue.getMoviesTitles().size()) {
//                    return catalogue.getMoviesTitles().get(movieID);
//                } else {
//                    ioHelper.print("You should enter a correct number");
//                }
//
//            } catch (NumberFormatException e) {
//                ioHelper.print("You should enter a correct number");
//            }
//        }
    }

    Languages languageChoosing(IOHelper ioHelper){

        ioHelper.print("Choose a movie language:");

        for (Languages language : Languages.values()) {
            ioHelper.print(language.ordinal() + 1 + ". " + language);
        }

        UserInteractingHelper userInteractingHelper = new UserInteractingHelper(ioHelper);

        int language = userInteractingHelper.takeUserChoice(1, Languages.values().length) - 1;

        return Languages.values()[language];

    }
}
