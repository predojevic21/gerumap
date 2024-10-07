package gerumap.app.messageGenerator;

import gerumap.app.core.MessageGenerator;
import gerumap.app.repository.view.observer.IPublisher;
import gerumap.app.repository.view.observer.ISubscriber;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImplementation  implements MessageGenerator{

    private List<ISubscriber> subsribers = new ArrayList<>();

     public void generateMessage(Event event){
         Message message=null;
         switch(event){
             case NODE_NOT_SELECTED:
                 message=new Message("Nije izabran node",EventType.ERROR, LocalDateTime.now());
                 break;
             case NAME_CANNOT_BE_EMPTY:
                 message=new Message("Ime ne moze biti prazno",EventType.WARNING, LocalDateTime.now());
                 break;
             case NODE_CANNOT_BE_DELETED:
                 message=new Message("Ne mozete obrisati ProjectExplorer",EventType.ERROR, LocalDateTime.now());
                 break;
             case NODE_CANNOT_HAVE_CHILDREN:
                 message=new Message("Element ne moze imati dete",EventType.ERROR, LocalDateTime.now());
                 break;
             case NO_ELEMENT_AT_CLICKED_POINT:
                 message = new Message("Kliknite na element",EventType.ERROR,LocalDateTime.now());
                 break;

         }
         notifySubscribers(message);
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
        if (notification == null || this.subsribers == null || this.subsribers.isEmpty())
            return;
        for (ISubscriber listener : subsribers) {
            listener.update(notification);
        }
    }

    @Override
    public void notifySubscribers(Object notification,String type){

    }
}
