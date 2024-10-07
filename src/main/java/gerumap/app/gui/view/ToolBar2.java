package gerumap.app.gui.view;

import javax.swing.*;

public class ToolBar2 extends JToolBar {

    public ToolBar2() {
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddElementAction());
        add(MainFrame.getInstance().getActionManager().getAddVezaAction());
        add(MainFrame.getInstance().getActionManager().getObrisiElementAction());
        add(MainFrame.getInstance().getActionManager().getMoveAction());
        add(MainFrame.getInstance().getActionManager().getSelectAction());
        add(MainFrame.getInstance().getActionManager().getColorAction());
        add(MainFrame.getInstance().getActionManager().getEditStateAction());
        add(MainFrame.getInstance().getActionManager().getAddCenterElementAction());

    }
}
