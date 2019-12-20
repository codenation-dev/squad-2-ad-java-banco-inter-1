package br.com.centralerros.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendEmailImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailRecuperarSenha(String email){
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(email);
        mensagem.setSubject("teste");
        mensagem.setText("");

        javaMailSender.send(mensagem);

    }
}
