/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.view;

import g57973.chess.model.Color;
import g57973.chess.model.Model;
import g57973.chess.model.Position;
import java.util.Scanner;

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
        System.out.println("Vous êtes le gagnant :");
    }
    
    
    @Override
    public void displayBoard() {

        System.out.print("Voici le plateau de jeu actuel");
        for (int i = 0; i < 8; i++) {
            System.out.println(i + 1);
            System.out.print("|");

            for (int j = 0; j < 8; j++) {
                Position pos = new Position(i, j);
                if (model.getPiece(pos) == null) {
                    System.out.print(" ");
                }
                if (model.getPiece(pos).getColor() == Color.BLACK) {
                    System.out.print("PN");
                }
                if (model.getPiece(pos).getColor() == Color.WHITE) {
                    System.out.print("PB");
                }
            }
            System.out.print("|");
           
        }
        System.out.println("A B C D E F G H");
    }

    @Override
    public void displayPlayer() {

    }

    @Override
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une position : ");
        Position nvpos = new Position(clavier.nextInt(), clavier.nextInt());
        return nvpos;
    }

    @Override
    public void displayError(String message) {

    }

}
