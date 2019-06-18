package common.post.model.office;

import common.post.model.product.PublishingProduct;
import common.post.model.publishing.PublishingObserver;

import java.util.ArrayList;
import java.util.List;

public class PostOffice implements PostOfficeObservable, PublishingObserver{

    final int ZIP_CODE;

    private List<PostOfficeObserver> observers;
    private PublishingProduct deliveringProduct;

    public PostOffice(int zip_code) {
        ZIP_CODE = zip_code;
        observers = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostOffice)) return false;

        PostOffice office = (PostOffice) o;

        return ZIP_CODE == office.ZIP_CODE;
    }

    @Override
    public int hashCode() {
        return ZIP_CODE;
    }

    @Override
    public void update(PublishingProduct product) {
        deliveringProduct = product;
        notifyPostOfficeObservers();
    }

    @Override
    public void registerPostOfficeObserver(PostOfficeObserver subscriber) {
        observers.add(subscriber);
    }

    @Override
    public void removePostOfficeObserver(PostOfficeObserver subscriber) {

    }

    @Override
    public void notifyPostOfficeObservers() {
        observers.forEach(o -> o.update(deliveringProduct));
    }
}
