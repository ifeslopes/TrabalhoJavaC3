/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.entidades;

import java.util.Random;

/**
 *
 * @author lopes
 */
public class Servico {
    
   
    public static int randomNumero(){
         Random random = new Random();
        return   random.nextInt(96) + 5;
    }
    
}
