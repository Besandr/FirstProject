package common.post.model.product;

public class Magazine extends PublishingProduct {

    public Magazine(String title) {
        this(title, 60);
    }

    public Magazine(String title, int periodicity) {
        this.title = title;
        this.periodicity = periodicity;
    }

}
