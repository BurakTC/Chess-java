/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.controller;

import g57973.chess.model.Model;
import g57973.chess.view.View;

/**
 *
 * @author Burak
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
    public void play(){
        boolean gameIsOver = false;
        view.displayTitle();
        
        game.start();
        
        while(!gameIsOver){
  
        }
        view.displayWinner();
    }

   
}
