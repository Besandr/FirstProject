package common.post.model.office;

import common.post.model.product.PublishingProduct;

public interface PostOfficeObserver {

    void update(PublishingProduct product);

}
