package command.specificcommand.areaCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import interpreter.Type;
import shapes.model.CircleObject;
import shapes.model.GraphicObject;
import shapes.model.ImageObject;
import shapes.model.RectangleObject;
import shapes.view.GraphicObjectPanel;

import java.util.Set;

public class AreaTypeCmd implements Command , DeclarativeCommand {
    private Type tipo;
    private GraphicObjectPanel gpanel;


    public AreaTypeCmd(Type tipo, GraphicObjectPanel gpanel) {
        this.tipo = tipo;
        this.gpanel = gpanel;
    }

    @Override
    public boolean doIt() {
        double res=0;
        Set<Integer> listaId = IdGenerator.ISTANCE.getKeySet();

        for (Integer i : listaId){
            GraphicObject go = IdGenerator.ISTANCE.get(i);
            switch (tipo.getSimbolo()){
                case RECTANGLE -> {
                    if (go instanceof RectangleObject){
                        res += go.area();
                    }
                }
                case IMAGE -> {
                    if (go instanceof ImageObject){
                        res += go.area();
                    }
                }
                case CIRCLE -> {
                    if (go instanceof CircleObject){
                        res += go.area();
                    }
                }
            }
        }
        System.out.println("La somma delle aree dei tipi "+tipo.getSimbolo()+": "+res);
        return false;
    }


    @Override
    public GraphicObject getGraphicObject() {
        return null;
    }
}
