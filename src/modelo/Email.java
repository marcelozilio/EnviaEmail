/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import enumerated.Host;

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
    private Host host;

    public static EmailBuilder builder(){
        return new EmailBuilder();
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

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public static final class EmailBuilder {
        private Email email=  new Email();

        public EmailBuilder emailRemetente(String emailRemetente) {
            email.setEmailRemetente(emailRemetente);
            return this;
        }

        public EmailBuilder senhaRemetente(String senhaRemetente) {
            email.setSenhaRemetente(senhaRemetente);
            return this;
        }

        public EmailBuilder emailDestinatario(String emailDestinatario) {
            email.setEmailDestinatario(emailDestinatario);
            return this;
        }

        public EmailBuilder assunto(String assunto) {
            email.setAssunto(assunto);
            return this;
        }

        public EmailBuilder menssagem(String menssagem) {
            email.setMenssagem(menssagem);
            return this;
        }

        public EmailBuilder host(Host host) {
            email.setHost(host);
            return this;
        }
        public Email build() {
            return email;
        }
    }
}
