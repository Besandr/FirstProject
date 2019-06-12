package common.post;

import common.post.model.office.PostOffice;
import common.post.model.office.PostOfficeObserver;
import common.post.model.product.Magazine;
import common.post.model.product.PublishingProduct;
import common.post.model.publishing.ConcretePublisher;
import common.post.model.publishing.Publisher;
import common.post.model.subscribe.Subscriber;

public class PostOfficeDemo {

    public static void main(String[] args) {
        new PostOfficeDemo().go();
    }

    public void go() {

        Publisher deAgostini = new ConcretePublisher();
        PublishingProduct spyRobotMagazine = new Magazine("Create spy-robot");
        deAgostini.addPublishingProduct(spyRobotMagazine);

        PostOffice office = new PostOffice(1601);
        deAgostini.registerPublishingObserver(office);

        PostOfficeObserver subscriber = new Subscriber("Andrey");
        office.registerPostOfficeObserver(subscriber);

        deAgostini.publish();
    }

}
