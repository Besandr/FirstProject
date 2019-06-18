package common.destribution;

enum Languages {
    UKRAINIAN("Українська"), RUSSIAN("Русский"), ENGLISH("English");

    String language;

    Languages(String language) {
        this.language = language;
    }

    @Override
    public String toString(){
        return language;
    }
}
