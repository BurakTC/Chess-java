/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.controller;

import g57973.chess.model.Game;
import g57973.chess.model.Model;
import g57973.chess.view.TextView;
import g57973.chess.view.View;

/**
 *
 * @author Burak
 */
public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void play() {
        boolean gameIsOver = false;
        view.displayTitle();

        model.start();
        
        while (!gameIsOver) {
            view.displayBoard();
            view.displayPlayer();            
            view.askPosition();
            
        }
        view.displayWinner();
    }

    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }

}
