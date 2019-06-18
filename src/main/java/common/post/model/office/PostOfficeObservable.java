package common.post.model.office;

public interface PostOfficeObservable {

    void registerPostOfficeObserver(PostOfficeObserver subscriber);

    void removePostOfficeObserver(PostOfficeObserver subscriber);

    void notifyPostOfficeObservers();

}
