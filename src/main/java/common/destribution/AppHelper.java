package common.destribution;

import utils.IOHelper;

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

        while (true) {

            String choice = ioHelper.input("Enter your choice: ");

            try {
                int movieID = Integer.parseInt(choice) - 1;

                if (movieID >= 0 && movieID < catalogue.getMoviesTitles().size()) {
                    return catalogue.getMoviesTitles().get(movieID);
                } else {
                    ioHelper.print("You should enter a correct number");
                }

            } catch (NumberFormatException e) {
                ioHelper.print("You should enter a correct number");
            }
        }
    }

    Languages languageChoosing(IOHelper ioHelper){

        ioHelper.print("Choose a movie language:");

        for (Languages language : Languages.values()) {
            ioHelper.print(language.ordinal() + 1 + ". " + language);
        }


        while (true) {

            String choice = ioHelper.input("Enter your choice: ");

            try {
                int language = Integer.parseInt(choice) - 1;

                if (language >= 0 && language < Languages.values().length) {

                    return Languages.values()[language];

                } else {
                    ioHelper.print("You should enter a correct number");
                }

            } catch (NumberFormatException e) {
                ioHelper.print("You should enter a correct number");
            }
        }

    }
}
