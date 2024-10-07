package gerumap.app.core;

import gerumap.app.messageGenerator.Message;
import gerumap.app.repository.view.observer.ISubscriber;

public interface ErrorLogger extends ISubscriber {

    public void log(Message message);
}
