/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.Email;
import util.EnviaEmail;
import util.Validacoes;

/**
 * @author Marcelo Zilio
 */
public class EnviaEmailController implements Initializable {

    @FXML
    private TextField tfEmailRemetente, tfEmailDestinatario, tfAssunto;

    @FXML
    private PasswordField psSenhaRemetente;

    @FXML
    private TextArea txtAreaMsg;

    @FXML
    private void enviarEmail(ActionEvent event) {
        try {
            new EnviaEmail().enviarGmail(
                    new Email(Validacoes.validaEmail(tfEmailRemetente.getText(), tfEmailRemetente),
                            Validacoes.validaTexto(psSenhaRemetente.getText(), "SENHA DO REMETENTE", psSenhaRemetente),
                            Validacoes.validaEmail(tfEmailDestinatario.getText(), tfEmailDestinatario),
                            Validacoes.validaTexto(tfAssunto.getText(), "ASSUNTO", tfAssunto),
                            Validacoes.validaTexto(txtAreaMsg.getText(), "MENSSAGEM", tfAssunto)));                                        
            limparCampos();            
            msg("E-MAIL ENVIADO COM SUCESSO", Alert.AlertType.INFORMATION);            
        } catch (Exception e) {
            msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }    

    private void limparCampos(){
        tfEmailRemetente.setText("");
        psSenhaRemetente.setText("");
        tfEmailDestinatario.setText("");
        tfAssunto.setText("");
        txtAreaMsg.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public static void msg(String msg, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Informação");        
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
