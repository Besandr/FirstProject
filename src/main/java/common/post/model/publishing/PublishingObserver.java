package common.post.model.publishing;

import common.post.model.product.PublishingProduct;

public interface PublishingObserver {

    void update(PublishingProduct product);

}
