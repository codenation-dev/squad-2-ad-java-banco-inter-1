package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.exception.NullObjectException;
import br.com.centralerros.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserServiceImpl userService;

    public void sendEmailRecuperarSenha(String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            String assunto = "Recuperção de Senha";
            String mensagem = String.format("A sua nova senha é: %d", Utils.getRandomPassword());

            sendEmail(assunto, mensagem, email);
        } else {
            throw new NullObjectException("Email não cadastrado em nossa base de dados");
        }

    }

    void sendEmail(String assunto, String mensagem, String email) {

        SimpleMailMessage objEmail = new SimpleMailMessage();
        objEmail.setTo(email);
        objEmail.setSubject(assunto);
        objEmail.setText(mensagem);

        javaMailSender.send(objEmail);
    }
}
