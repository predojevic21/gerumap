package gerumap.app.repository.view.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);
    void notifySubscribers(Object notification,String type);
}
