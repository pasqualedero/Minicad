package command.specificcommand.listCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import interpreter.ObjID;
import shapes.model.GraphicObject;
import shapes.view.GraphicObjectPanel;

public class ListIdCmd implements Command , DeclarativeCommand {
    private GraphicObject go;
    private GraphicObjectPanel gpanel;

    public ListIdCmd(ObjID id, GraphicObjectPanel gpanel) {
        this.go = IdGenerator.ISTANCE.get(id.getId());
        this.gpanel = gpanel;
    }

    @Override
    public boolean doIt() {
        System.out.println(go.toString());
        return false;
    }


    @Override
    public GraphicObject getGraphicObject() {
        return null;
    }
}
