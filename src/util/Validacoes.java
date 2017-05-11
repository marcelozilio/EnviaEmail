package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.TextField;

/**
 * Created by Marcelo on 12/08/2016.
 * @version 0.2
 */
public class Validacoes {

    private static final SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
    private static Date date;

    public static String validaNumero(String numero, String campo, TextField textField) throws Exception {
        try {
            float num = Float.parseFloat(numero);
            return numero;
        } catch (Exception e) {
            textField.requestFocus();
            throw new Exception("Digite um número válido no campo " + campo + ".");
        }
    }

    public static String validaTexto(String texto, String campo, TextField textField) throws Exception {
        if (texto.trim().length() != 0)
            return texto;
        textField.requestFocus();
        throw new Exception("O campo "+ campo +" não pode ser vazio.");
    }
    
    public static boolean validaRA(String ra) throws Exception{
        if(ra.length() == 11)
            return true;       
        throw new Exception("RA inválido.");
    }

    public static String validaEmail(String email, TextField textField) throws Exception {
        if(email.matches("[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+"))
            return email;
        textField.requestFocus();
        throw new Exception("E-mail inválido.");
    }

    public static boolean validaData(String data) throws Exception {
        return data.length() != 10;
    }

    /**
     * Converte uma data no formato ISO em formato ABNT;
     *
     * @param dataIso Argumento que recebe data no formato ISO(yyyy-MM-dd);
     * @return Uma data no formato ABNT(dd/MM/yyyy)
     * @throws java.lang.Exception
     */
    public static String parseDtaBra(String dataIso) throws Exception {
        try {
            date = formatIso.parse(dataIso);
            return (formatBra.format(date));
        } catch (ParseException e) {
            throw new Exception("Formato da data é inválido " + dataIso);
        }
    }

    /**
     * Converte uma data no formato ABNT em formato ISO;
     *
     * @param dataBra Argumento que recebe data no formato ABNT(dd/MM/yyyy);
     * @return Uma data no formato ISO(yyyy-MM-dd).
     * @throws java.lang.Exception
     */
    public static String parseDataIso(String dataBra) throws Exception {
        try {
            date = formatBra.parse(dataBra);
            return (formatIso.format(date));
        } catch (ParseException e) {
            throw new Exception("Formato da data é inválido " + dataBra);
        }
    }

}
