package gerumap.app.repository.view.observer;

public interface ISubscriber {
    void update(Object notification);
    void update(Object notification,String type);
}
