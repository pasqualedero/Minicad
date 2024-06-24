package command.specificcommand.listCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import shapes.model.CompositeObject;
import shapes.model.GraphicObject;

import java.util.Set;

public class ListAllGroupsCmd implements Command , DeclarativeCommand {
    private boolean all;

    public ListAllGroupsCmd(boolean all) {
        this.all = all;
    }

    @Override
    public boolean doIt() {
        String res ="";
        Set<Integer> listaID = IdGenerator.ISTANCE.getKeySet();

        for (Integer i : listaID){
            GraphicObject go = IdGenerator.ISTANCE.get(i);
            if (!all && go instanceof CompositeObject)
                res += go + "\n";
            else if (all && !(go instanceof CompositeObject))
                res += go + "\n";
        }
        System.out.println(res);
        return false;
    }


    @Override
    public GraphicObject getGraphicObject() {
        return null;
    }
}
