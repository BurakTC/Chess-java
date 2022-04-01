/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.view;

import g57973.chess.model.Board;
import g57973.chess.model.Model;
import g57973.chess.model.Position;

/**
 *
 * @author g57973
 */
public class TextView implements View {

    private Model model;

    public TextView(Model model) {
        this.model = model;
    }

    @Override
    public void displayTitle() {
        System.out.println("Bienvenue au jeu d'échecs !");
    }

    @Override
    public void displayWinner() {
        System.out.println();
    }

    @Override
    public void displayBoard() {
        

    }

    @Override
    public void displayPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position askPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayError(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
