package gerumap.app.gui.state;

import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.view.observer.IPublisher;
import gerumap.app.repository.view.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class State implements IPublisher {

    public List<ISubscriber> subsribers=new ArrayList<>();


    public abstract void misKliknut(int x, int y, MindMap mindMap);
    public abstract void misPovucen(int x, int y, MindMap mindMap);
    public abstract void misOtpusten(int x, int y, MindMap mindMap);

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null)
            return;
        if (subsribers.isEmpty())
            subsribers = new ArrayList<>();
        if (!(subsribers.contains(sub)))
            subsribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || this.subsribers == null || !this.subsribers.contains(sub))
            return;
        this.subsribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.subsribers == null || this.subsribers.isEmpty())
            return;
        for (ISubscriber listener : subsribers) {
            listener.update(notification);
        }

    }

    @Override
    public void notifySubscribers(Object notification, String type) {
        if (notification == null || this.subsribers == null || this.subsribers.isEmpty())
            return;
        for (ISubscriber listener : subsribers) {
            listener.update(notification,type);
        }
    }
}
