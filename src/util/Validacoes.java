package util;

import javafx.scene.control.TextField;

/**
 * Created by Marcelo on 12/08/2016.
 * @version 0.2
 */
public class Validacoes {


    public static String validaTexto(String texto, String campo, TextField textField) throws Exception {
        if (texto.trim().length() != 0)
            return texto;
        textField.requestFocus();
        throw new Exception("O campo "+ campo +" não pode ser vazio.");
    }



}
