package gerumap.app.gui.view;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);

        add (MainFrame.getInstance().getActionManager().getNewProjectAction());
        add (MainFrame.getInstance().getActionManager().getDeleteAction());
        add (MainFrame.getInstance().getActionManager().getInfoAction());
        add (MainFrame.getInstance().getActionManager().getChangeName());
        add (MainFrame.getInstance().getActionManager().getChangeAutor());
        add (MainFrame.getInstance().getActionManager().getExitAction());
        add (MainFrame.getInstance().getActionManager().getPictureOfPanelAction());
        add (MainFrame.getInstance().getActionManager().getSaveAction());
        add (MainFrame.getInstance().getActionManager().getSaveAsAction());
        add (MainFrame.getInstance().getActionManager().getOpenAction());
        add (MainFrame.getInstance().getActionManager().getSaveSchemeAction());
        add (MainFrame.getInstance().getActionManager().getLoadSchemeAction());

    }
}
