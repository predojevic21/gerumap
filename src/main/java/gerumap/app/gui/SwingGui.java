package gerumap.app.gui;

import gerumap.app.core.Gui;
import gerumap.app.gui.dialog.EventDialog;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Message;

public class SwingGui implements Gui{

    private MainFrame instance;

    public SwingGui() {
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }


    @Override
    public void update(Object notification) {
        if(notification instanceof Message){
            EventDialog dialog=new EventDialog((Message) notification);
            dialog.setVisible(true);
        }
    }
    @Override
    public void update(Object notification,String type){

    }
}
