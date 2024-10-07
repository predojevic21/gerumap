package gerumap.app.repository.implementation;

import gerumap.app.repository.view.observer.IPublisher;
import gerumap.app.repository.view.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapSelectionModel implements IPublisher {
    List<Element> selectedElements = new ArrayList<>();
    private List<ISubscriber> subsribers = new ArrayList<>();


    public void addSelectedChild(Element element){
        if(element != null) {
            selectedElements.add(element);
        }
        notifySubscribers(element,"select");
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
    public void notifySubscribers(Object notification) {

    }

    @Override
    public void notifySubscribers(Object notification,String type) {
        if (notification == null || this.subsribers == null || this.subsribers.isEmpty())
            return;
        for (ISubscriber listener : subsribers) {
            listener.update(notification,type);
        }
    }
}
