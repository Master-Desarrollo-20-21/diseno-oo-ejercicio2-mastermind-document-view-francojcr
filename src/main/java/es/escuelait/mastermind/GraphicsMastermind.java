package es.escuelait.mastermind;

import es.escuelait.mastermind.views.View;
import es.escuelait.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind {

    @Override
    protected View createView() {
        return new GraphicsView();
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }    
}