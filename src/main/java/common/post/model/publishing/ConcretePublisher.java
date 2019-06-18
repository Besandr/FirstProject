package common.post.model.publishing;

import common.post.model.product.PublishingProduct;

import java.util.ArrayList;

public class ConcretePublisher extends Publisher {

    public ConcretePublisher(){
        observers = new ArrayList<>();
    }

    @Override
    public void addPublishingProduct(PublishingProduct product) {
        this.product = product;
    }

    @Override
    public void registerPublishingObserver(PublishingObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removePublishingObserver(PublishingObserver observer) {
        int index;
        if ((index = observers.indexOf(observer)) != -1) {
            observers.remove(index);
        }
    }

    @Override
    public void publish() {
        product.setContent("New awesome content");

        notifyPublishingObservers();
    }

    @Override
    public void notifyPublishingObservers() {
        observers.forEach(o -> o.update(product));
    }
}
