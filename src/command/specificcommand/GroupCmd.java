package command.specificcommand;

import command.Command;
import id.IdGenerator;
import interpreter.ListID;
import interpreter.ObjID;
import interpreter.exception.InvalidID;
import shapes.model.CompositeObject;
import shapes.model.GraphicObject;
import shapes.view.GraphicObjectPanel;

import java.util.LinkedList;

public class GroupCmd implements Command {

    private LinkedList<ObjID> lista;
    private GraphicObjectPanel gpanel;
    private GraphicObject composite;

    public GroupCmd(ListID lista, GraphicObjectPanel gpanel) {
        this.lista = lista.getListaID();
        this.gpanel = gpanel;
    }

    @Override
    public boolean doIt() {
        LinkedList<Integer> listaInteger = new LinkedList<>();
        for (ObjID id : lista){
            IdGenerator.ISTANCE.get(id.getId()); // vedo se lancia eccezione
            listaInteger.add(id.getId());
        }

        this.composite = new CompositeObject(listaInteger);
        int compositeId = IdGenerator.ISTANCE.add(composite);
        System.out.println("ID: "+compositeId);

        return false;
    }

    @Override
    public GraphicObject getGraphicObject() {
        return composite;
    }
}
