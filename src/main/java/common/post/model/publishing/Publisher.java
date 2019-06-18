package common.post.model.publishing;

import common.post.model.product.PublishingProduct;

import java.util.List;

public abstract class Publisher {

    List<PublishingObserver> observers;
    PublishingProduct product;

    public abstract void registerPublishingObserver(PublishingObserver observer);

    public abstract void removePublishingObserver(PublishingObserver observer);

    public abstract void notifyPublishingObservers();

    public abstract void addPublishingProduct(PublishingProduct product);

    abstract public void publish();


}
