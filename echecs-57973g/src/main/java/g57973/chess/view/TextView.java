/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.view;

import g57973.chess.model.Color;
import static g57973.chess.model.Color.WHITE;
import g57973.chess.model.Model;
import g57973.chess.model.Player;
import g57973.chess.model.pieces.Piece;
import g57973.chess.model.Position;
import java.util.Scanner;

/**
 *
 * @author g57973
 */
public class TextView implements View {

    private final Model model;

    public TextView(Model model) {
        this.model = model;
    }

    @Override
    public void displayTitle() {
        System.out.println("Bienvenue au jeu d'échecs !");
    }

    @Override
    public void displayWinner() {
        System.out.println("Vous êtes le gagnant :" + model.getCurrentPlayer().getColor());
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
                    System.out.print(piece);
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
        System.out.println("Au tour du joueur " + model.getCurrentPlayer());
    }

    @Override
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        String oldPos = clavier.nextLine();

        char eligne = oldPos.charAt(0);
        char ecolonne = oldPos.charAt(1);
        int ligne;
        int colonne;
        switch (eligne) {
            case '1':
                ligne = 0;
                break;
            case '2':
                ligne = 1;
                break;
            case '3':
                ligne = 2;
                break;
            case '4':
                ligne = 3;
                break;
            case '5':
                ligne = 4;
                break;
            case '6':
                ligne = 5;
                break;
            case '7':
                ligne = 6;
                break;
            case '8':
                ligne = 7;
                break;
            default:
                throw new IllegalArgumentException("Positionde départ mal entrée !");

        }
        switch (ecolonne) {
            case 'a':
                colonne = 0;
                break;
            case 'b':
                colonne = 1;
                break;
            case 'c':
                colonne = 2;
                break;
            case 'd':
                colonne = 3;
                break;
            case 'e':
                colonne = 4;
                break;
            case 'f':
                colonne = 5;
                break;
            case 'g':
                colonne = 6;
                break;
            case 'h':
                colonne = 7;
                break;
            default:
                throw new IllegalArgumentException("Position de destination mal entrée !");
        }
        
        Position newPos = new Position(ligne, colonne);
        return newPos;
    }

    @Override
    public void displayError(String message) {
        System.out.println("Erreur : " + message);
    }

    @Override
    public void displayCheck() {
        System.out.println("Attention, vous etes en échec, déplacez votre roi !");
    }

    @Override
    public void displayMat(){
        System.out.println("Echec et mat, le joueur courant gagne la partie");
    }
    
    @Override
    public void displayStaleMat(){
        System.out.println("Plus de mouvements valides possibles, partie nulle !");
    }
}
