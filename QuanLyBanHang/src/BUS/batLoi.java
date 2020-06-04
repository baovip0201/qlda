/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import javax.swing.JTextField;

/**
 *
 * @author MSI
 */
public class batLoi {
    public static boolean Catch(String txt){
        if("".equals(txt)){
            return true;
        }
        return false;
}

    public static boolean Catch(JTextField txt_tenLoai_cnls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
