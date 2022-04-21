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
                        System.out.print("  PB | ");
                    } else {
                        System.out.print("  PN | ");
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
        if (model.getCurrentPlayer().getColor() == Color.WHITE) {
            System.out.println("Au tour du joueur BLANC !");
        } else {
            System.out.println("Au tour du joueur NOIR !");
        }

    }

    @Override
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez la position du pion à déplacer -> ligne,colonne");
        String posDepart = clavier.nextLine();

        char cligne = posDepart.charAt(0);
        char ccolonne = posDepart.charAt(1);
        int ligne;
        int colonne;
        switch (cligne) {
            case '1':
                ligne = 7;
                break;
            case '2':
                ligne = 6;
                break;
            case '3':
                ligne = 5;
                break;
            case '4':
                ligne = 4;
                break;
            case '5':
                ligne = 3;
                break;
            case '6':
                ligne = 2;
                break;
            case '7':
                ligne = 1;
                break;
            default : throw new IllegalArgumentException("erreurdep");

        }
        switch (ccolonne) {

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
            default : throw new IllegalArgumentException("erreur dep");
        }
        
        Position oldPos = new Position(ligne,colonne);
        System.out.println(oldPos.getRow());
        System.out.println(oldPos.getColumn());

        System.out.println("Entrez la position destinataire -> ligne,colonne");
        String destination = clavier.nextLine();
        
        char cligneDest = destination.charAt(0);
        char ccolDest = destination.charAt(1);
        int ligneDest;
        int colDest;
        switch (cligneDest) {
            case '1':
                ligneDest = 7;
                break;
            case '2':
                ligneDest = 6;
                break;
            case '3':
                ligneDest = 5;
                break;
            case '4':
                ligneDest = 4;
                break;
            case '5':
                ligneDest = 3;
                break;
            case '6':
                ligneDest = 2;
                break;
            case '7':
                ligneDest = 1;
                break;
                            default : throw new IllegalArgumentException("erreur dest");

        }
        switch (ccolDest) {

            case 'a':
                colDest = 0;
                break;
            case 'b':
                colDest = 1;
                break;
            case 'c':
                colDest = 2;
                break;
            case 'd':
                colDest = 3;
                break;
            case 'e':
                colDest = 4;
                break;
            case 'f':
                colDest = 5;
                break;
            case 'g':
                colDest = 6;
                break;
            case 'h':
                colDest = 7;
                break;
                            default : throw new IllegalArgumentException("erreur destination");

        }
        
        Position newPos = new Position(ligneDest, colDest);
        System.out.println(newPos.getRow());
        System.out.println(newPos.getColumn());
        
        model.movePiecePosition(oldPos, newPos);
        return newPos;
    }

    @Override
    public void displayError(String message) {
        System.out.println("Erreur : " + message);
    }

   
}
