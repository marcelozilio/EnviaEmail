/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

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

import java.net.URL;
import java.util.ResourceBundle;

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

    public static void msg(String msg, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void enviarEmail(ActionEvent event) {
        try {
            EnviaEmail.envia(
                    Email.builder()
                            .emailRemetente(tfEmailRemetente.getText())
                            .senhaRemetente(Validacoes.validaTexto(psSenhaRemetente.getText(), "SENHA DO REMETENTE", psSenhaRemetente))
                            .emailDestinatario(tfEmailDestinatario.getText())
                            .assunto(Validacoes.validaTexto(tfAssunto.getText(), "ASSUNTO", tfAssunto))
                            .menssagem(Validacoes.validaTexto(txtAreaMsg.getText(), "MENSSAGEM", tfAssunto))
                            .build());

            limparCampos();
            msg("E-MAIL ENVIADO COM SUCESSO", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void limparCampos() {
        tfEmailRemetente.setText("");
        psSenhaRemetente.setText("");
        tfEmailDestinatario.setText("");
        tfAssunto.setText("");
        txtAreaMsg.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
