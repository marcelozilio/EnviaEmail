/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marcelo
 */
public class Email {
    
    private String emailRemetente;
    private String senhaRemetente;
    private String emailDestinatario;
    private String assunto;
    private String menssagem;

    public Email() {
    }
    
    public Email(String emailRemetente, String senhaRemetente, String emailDestinatario, String assunto, String menssagem) {
        this.emailRemetente = emailRemetente;
        this.senhaRemetente = senhaRemetente;
        this.emailDestinatario = emailDestinatario;
        this.assunto = assunto;
        this.menssagem = menssagem;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public String getSenhaRemetente() {
        return senhaRemetente;
    }

    public void setSenhaRemetente(String senhaRemetente) {
        this.senhaRemetente = senhaRemetente;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

}
