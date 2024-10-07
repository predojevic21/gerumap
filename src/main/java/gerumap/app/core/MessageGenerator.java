package gerumap.app.core;

import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.view.observer.IPublisher;

public interface MessageGenerator extends IPublisher {
    public void generateMessage(Event event);
}
