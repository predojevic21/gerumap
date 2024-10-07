package gerumap.app.errorLogger;

import gerumap.app.core.ErrorLogger;
import gerumap.app.messageGenerator.Message;

import java.io.File;
import java.io.FileWriter;

public class FileLogger implements ErrorLogger {

    @Override
    public void log(Message message) {
        File f=null;
        try {
            f=new File("src/main/resources/log.txt");
            f.createNewFile();
            FileWriter fw=new FileWriter(f,true);
            fw.write(message.toString());
            fw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Message)
            this.log((Message)notification);
    }

    public void update(Object notification,String type){

    }
}
