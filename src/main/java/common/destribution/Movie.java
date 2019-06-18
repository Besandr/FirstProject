package common.destribution;

import java.util.HashMap;

abstract class Movie {

    String name;

    Movie(String name) {
        this.name = name;
    }

    String getName(){
        return name;
    }

}
