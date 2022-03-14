/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 *
 * @author g57973
 */
public enum Color {
    WHITE,BLACK;

    
    
   /**
    * 
    * @param color
    * @return  Opposite Color of gived color. 
    */
    public Color opposite(Color color){
        /**
         * CE QUE PROF A FAIT :
         * return color==Color.BLACK ? Color.WHITE : Color.BLACK    
         */
        
        if(color == WHITE){
            return BLACK;
        }
        else {
            return WHITE;
        }
    }
    
    
    
}
