/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.view;

import g57973.chess.model.Position;

/**
 *
 * @author g57973
 */
public interface View {
    
    public void displayTitle();
    
    public void displayBoard();
    
    public void displayWinner();
    
    public void displayPlayer();
    
    public Position askPosition();
    
    public void displayError(String message);
        
    
    

    
}
