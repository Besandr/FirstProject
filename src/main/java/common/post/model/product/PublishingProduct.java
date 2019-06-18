package common.post.model.product;

import java.util.concurrent.TimeUnit;

public abstract class PublishingProduct {

    String title;
    int periodicity;
    String content;

    public void setContent(String newContent) {
        content = newContent;
    }

    public String getTitle(){
        return title;
    }

}
