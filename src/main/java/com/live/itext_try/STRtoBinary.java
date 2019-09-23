/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.live.itext_try;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 *
 * @author T43422
 */
public class STRtoBinary {

    String cad;

    public STRtoBinary(String st) {
        cad = st;
    }

    public String toBinary() {
        CharacterIterator it = new StringCharacterIterator(cad);
        String binary = "";
        while (it.current() != CharacterIterator.DONE) {
            //System.out.print(it.current());
            binary+=Integer.toBinaryString(cad.charAt(0));
            it.next();
        }

        return binary;
    }
}
