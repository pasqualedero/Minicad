package command.specificcommand.perimeterCmd;

import command.Command;
import command.DeclarativeCommand;
import id.IdGenerator;
import interpreter.Type;
import shapes.model.CircleObject;
import shapes.model.GraphicObject;
import shapes.model.ImageObject;
import shapes.model.RectangleObject;
import shapes.view.GraphicObjectPanel;

import java.awt.geom.Point2D;
import java.util.Set;

public class PerimeterTypeCmd implements Command , DeclarativeCommand {
    private Type tipo;
    private GraphicObjectPanel gpanel;


    public PerimeterTypeCmd(Type tipo, GraphicObjectPanel gpanel) {
        this.tipo = tipo;
        this.gpanel = gpanel;
    }

    @Override
    public boolean doIt() {
        double res=0;
        Set<Integer> listaId = IdGenerator.ISTANCE.getKeySet();
        Class<? extends GraphicObject> classe = null;

        switch (tipo.getSimbolo()){
            case IMAGE -> classe = ImageObject.class;
            case RECTANGLE -> classe = RectangleObject.class;
            case CIRCLE -> classe = CircleObject.class;
        }

        for (Integer i : listaId){
            GraphicObject go = IdGenerator.ISTANCE.get(i);
            if (classe.isInstance(go))
                res += go.perimetro();
        }
        System.out.println("La somma dei perimetri dei tipi "+tipo.getSimbolo()+": "+res);
        return false;
    }


    @Override
    public GraphicObject getGraphicObject() {
        return null;
    }
}
