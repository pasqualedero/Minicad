package command.specificcommand.areaCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import interpreter.ObjID;
import shapes.model.GraphicObject;
import shapes.view.GraphicObjectPanel;

public class AreaIdCmd implements Command , DeclarativeCommand {
    private GraphicObjectPanel  gpanel;
    private GraphicObject go;

    public AreaIdCmd(ObjID id, GraphicObjectPanel gpanel) {
        this.gpanel = gpanel;
        go = IdGenerator.ISTANCE.get(id.getId());
    }

    @Override
    public boolean doIt() {
        System.out.println("Area di "+go +": "+go.area());
        return false;
    }


    @Override
    public GraphicObject getGraphicObject() {
        return null;
    }
}
