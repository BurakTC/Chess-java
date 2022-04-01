/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.view;

import g57973.chess.model.Color;
import g57973.chess.model.Model;
import g57973.chess.model.Piece;
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

        System.out.println("Voici le plateau de jeu actuel");

        int row = 7;
        int column = 0;
        System.out.println("  " + "-".repeat(56));

        for (int i = 8; 0 < i; i--) {
            System.out.print(i + " |");//cpt lignes

            for (int j = 0; j < 8; j++) {

                if (column == 8) {
                    column = 0;
                    row--;
                }
                Position pos = new Position(row, column);
                Piece piece = this.model.getPiece(pos);

                if (piece != null) {
                    if (piece.getColor().equals(Color.WHITE)) {
                        System.out.print("PB | ");
                    } else {
                        System.out.print("PN | ");
                    }
                } else {
                    System.out.print("     | ");
                }
                column++;
            }
            System.out.println();
            System.out.println("  " + "-".repeat(56));

        }
        System.out.println(" ".repeat(6) + "a" + " ".repeat(6) + "b" + " ".repeat(6) + "c" + " ".repeat(6) + "d" + " ".repeat(6) + "e" + " ".repeat(6) + "f" + " ".repeat(6) + "g" + " ".repeat(6) + "h");
    }
    
    
    
    @Override
    public void displayPlayer() {
        System.out.println(model.getCurrentPlayer());

    }

    @Override
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une position au format ligne_" + " espace " + "_colonne : ");
        Position nvpos = new Position(clavier.nextInt(), clavier.nextInt());
        return nvpos;
    }

    @Override
    public void displayError(String message) {
        System.out.println("Erreur : " + message);
    }
}
