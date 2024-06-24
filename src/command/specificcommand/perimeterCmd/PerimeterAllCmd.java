package command.specificcommand.perimeterCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import shapes.model.GraphicObject;
import shapes.view.GraphicObjectPanel;

import java.util.Set;

public class PerimeterAllCmd implements Command , DeclarativeCommand {
    private GraphicObjectPanel gpanel;

    public PerimeterAllCmd(GraphicObjectPanel gpanel) {
        this.gpanel = gpanel;
    }

    @Override
    public boolean doIt() {
        double res=0;
        Set<Integer> listaId = IdGenerator.ISTANCE.getKeySet();

        for (Integer i : listaId){
            res += IdGenerator.ISTANCE.get(i).perimetro();
        }
        System.out.println("Somma perimetri: "+res);
        return false;
    }


    @Override
    public GraphicObject getGraphicObject() {
        return null;
    }
}
