package gerumap.app;

import gerumap.app.core.*;
import gerumap.app.errorLogger.ConsoleLogger;
import gerumap.app.errorLogger.FileLogger;
import gerumap.app.gui.SwingGui;
import gerumap.app.messageGenerator.MessageGeneratorImplementation;
import gerumap.app.repository.MapRepositoryImplementation;
import gerumap.app.serializer.GsonSerializer;

import java.io.File;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImplementation();
        MessageGenerator messageGenerator=new MessageGeneratorImplementation();
        ErrorLogger errorLogger;
        Serializer serializer = new GsonSerializer();
        //if(args[0]=="console")
            errorLogger=new ConsoleLogger();
       // else
        //    errorLogger=new FileLogger();

        appCore.initialise(gui, mapRepository,errorLogger,messageGenerator,serializer);
        appCore.run();


    }
}
