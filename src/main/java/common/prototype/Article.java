package common.prototype;

abstract class Article implements Cloneable {

    String title;
    String content;

    Article(String name, String content) {
        this.title = name;
        this.content = content;
    }

    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignored){return null;}
    }

    String getTitle() {
        return title;
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        return title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
