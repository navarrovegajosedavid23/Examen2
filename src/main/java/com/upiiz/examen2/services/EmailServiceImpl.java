package com.upiiz.examen2.services;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.upiiz.examen2.entities.EmailEntity;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService
{
    
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;



    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine)
    {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(EmailEntity emailEntity)
    
    {
        try {
            MimeMessage message = 
                javaMailSender.createMimeMessage();
            MimeMessageHelper helper = 
                new MimeMessageHelper(message,true, "UTF-8");

            helper.setTo(emailEntity.getDestinatario());
            helper.setSubject(emailEntity.getAsunto());

            Context context = new Context();
            context.setVariable("mensaje", emailEntity.getMensaje());
            String contentHTML = templateEngine.process("Sesion/email",
                context);

            helper.setText(contentHTML, true);
            javaMailSender.send(message);
            System.out.println("Correo enviado a " + emailEntity.getDestinatario());
    }   catch(Exception e)
    {
        throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
    }
}
}