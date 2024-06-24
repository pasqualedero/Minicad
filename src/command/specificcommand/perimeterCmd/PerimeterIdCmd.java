package command.specificcommand.perimeterCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import interpreter.ObjID;
import shapes.model.GraphicObject;
import shapes.view.GraphicObjectPanel;

public class PerimeterIdCmd implements Command , DeclarativeCommand {
    private ObjID id;
    private GraphicObjectPanel gpanel;
    private GraphicObject go;

    public PerimeterIdCmd(ObjID id, GraphicObjectPanel gpanel) {
        this.id = id;
        this.gpanel = gpanel;
        go = IdGenerator.ISTANCE.get(id.getId());
    }

    @Override
    public boolean doIt() {
        System.out.println("Perimetro di "+id+": "+go.perimetro());
        return false;
    }



    @Override
    public GraphicObject getGraphicObject() {
        return go;
    }
}
