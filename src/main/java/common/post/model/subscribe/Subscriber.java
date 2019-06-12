package common.post.model.subscribe;

import common.post.model.office.PostOfficeObserver;
import common.post.model.product.PublishingProduct;

public class Subscriber implements PostOfficeObserver {

    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(PublishingProduct product) {
        System.out.println( name + " got new mail: " + product.getTitle());
    }
}
