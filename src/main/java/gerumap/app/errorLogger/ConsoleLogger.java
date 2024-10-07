package gerumap.app.errorLogger;

import gerumap.app.core.ErrorLogger;
import gerumap.app.messageGenerator.Message;

public class ConsoleLogger implements ErrorLogger {

    @Override
    public void log(Message message) {
        System.out.println(message.toString());
    }

    public void update(Object notification) {
        if(notification instanceof Message)
            this.log((Message)notification);
    }

    public void update(Object notification,String type){

    }
}
