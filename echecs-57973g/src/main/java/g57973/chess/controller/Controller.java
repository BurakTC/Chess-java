/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.controller;

import g57973.chess.model.Game;
import g57973.chess.model.GameState;
import g57973.chess.model.Model;
import g57973.chess.model.Position;
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
        view.displayTitle();
        model.start();
        while (model.getState()== GameState.PLAY || model.getState()== GameState.PLAY) {
            view.displayBoard();
            view.displayPlayer();

            System.out.println("Entrez une position de départ :");
            Position oldPos = view.askPosition();
            System.out.println("Entrez la position de destination :");
            Position newPos = view.askPosition();
            
            if(model.isValidMove(oldPos,newPos)&& model.getPossibleMoves(oldPos).contains(newPos)){
            model.movePiecePosition(oldPos, newPos);
            }
            if(model.getState()== GameState.CHECK){
                view.displayCheck();
           }
            if(model.getState()== GameState.STALE_MAT){
                view.displayStaleMat();
           }
            if(model.getState()== GameState.CHECK_MAT){
                view.displayMat();
           }
        }
        view.displayWinner();
    }

    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }

}
