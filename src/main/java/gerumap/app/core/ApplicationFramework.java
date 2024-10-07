package gerumap.app.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger errorLogger;
    protected MessageGenerator messageGenerator;
    protected Serializer serializer;

    public void run(){
        this.gui.start();
    }

    public void initialise(Gui gui, MapRepository mapRepository,ErrorLogger errorLogger,MessageGenerator messageGenerator,Serializer serializer)
    {
        this.gui = gui;
        this.mapRepository = mapRepository;
        //treba da se proslede i u konstruktor...
        this.errorLogger = errorLogger;
        this.messageGenerator = messageGenerator;
        this.serializer = serializer;

        this.messageGenerator.addSubscriber(errorLogger);
        this.messageGenerator.addSubscriber(gui);
    }

    private static ApplicationFramework instance;

    private ApplicationFramework(){

    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

}
