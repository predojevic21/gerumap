package gerumap.app.gui.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {
    private ExitAction exitAction;
    private NewAction newProjectAction;
    private DeleteAction deleteAction;
    private InfoAction infoAction;
    private ChangeName changeName;
    private ChangeAutor changeAutor;
    private AddElementAction addElementAction;
    private AddVezaAction addVezaAction;
    private ObrisiElementAction obrisiElementAction;
    private MoveAction moveAction;
    private SelectAction selectAction;
    private ColorAction colorAction;
    private EditStateAction editStateAction;
    private AddCenterElementAction addCenterElementAction;
    private PictureOfPanelAction pictureOfPanelAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private OpenAction openAction;
    private SaveSchemeAction saveSchemeAction;
    private LoadSchemeAction loadSchemeAction;


    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        changeName = new ChangeName();
        changeAutor = new ChangeAutor();
        addElementAction = new AddElementAction();
        addVezaAction = new AddVezaAction();
        obrisiElementAction = new ObrisiElementAction();
        moveAction = new MoveAction();
        selectAction = new SelectAction();
        colorAction = new ColorAction();
        editStateAction = new EditStateAction();
        addCenterElementAction = new AddCenterElementAction();
        pictureOfPanelAction = new PictureOfPanelAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        openAction = new OpenAction();
        saveSchemeAction = new SaveSchemeAction();
        loadSchemeAction = new LoadSchemeAction();
    }

}
