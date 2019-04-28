/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Interfaces.CommandInterface;

/**
 *
 * @author xg6856vd
 */
public class DoNothingCommand implements CommandInterface{
    
    @Override
    public void execute(int i) {
        System.out.println();
    }
}
