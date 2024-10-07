package gerumap.app.gui.state;

import gerumap.app.gui.state.concrete.*;

public class StateManager {

    private AddPojamState addPojamState;
    private AddVezaState addVezaState;
    private MoveState moveState;
    private ObrisiState obrisiState;
    private SelectState selectState;
    private EditState editState;
    private ColorState colorState;
    private AddCeenterElementState addCeenterElementState;
    private State current;

    public StateManager() {
        init();
    }

    private void init() {
        addPojamState = new AddPojamState();
        addVezaState = new AddVezaState();
        moveState = new MoveState();
        obrisiState = new ObrisiState();
        selectState = new SelectState();
        editState = new EditState();
        colorState = new ColorState();
        addCeenterElementState = new AddCeenterElementState();
        current = addPojamState;
    }

    public State getCurrent(){
        return current;
    }

    public void setAddPojamState(){
        current = addPojamState;
    }
    public void setAddVezaState(){
        current = addVezaState;
    }
    public void setMoveState(){
        current = moveState;
    }
    public void setObrisiState(){
        current = obrisiState;
    }
    public void setSelectState(){
        current = selectState;
    }
    public void setEditState(){current = editState;}
    public void setColorState(){current = colorState;}
    public void setAddCeenterElementState(){current = addCeenterElementState;}
}
