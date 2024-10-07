package gerumap.app.repository.composite;

import gerumap.app.repository.view.observer.IPublisher;
import gerumap.app.repository.view.observer.ISubscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class MapNode implements IPublisher {

    protected String name;
    @ToString.Exclude
    private transient MapNode parent;
    private transient List<ISubscriber> subsribers = new ArrayList<>();

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

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
    public void notifySubscribers(Object notification,String type) {
        if (notification == null || this.subsribers == null || this.subsribers.isEmpty())
            return;
        for (ISubscriber listener : subsribers) {
            listener.update(notification,type);
        }
    }

    @Override
    public void notifySubscribers(Object notification){

    }

}
