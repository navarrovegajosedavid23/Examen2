package com.upiiz.examen2.controllers;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration

public class EmailConfig {
    // Aquí puedes configurar los detalles de tu servidor de correo electrónico
    // como el host, puerto, usuario y contraseña.
    @Value("${email.username}")
    private String emailUsername;

    @Value("${password.username}")
    private String emailPassword;

    private Properties getMailProperties()
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp" + ".gmail.com");
        properties.put("mail.smtp.port","587");

        return properties;
    }

    @Bean 
    public JavaMailSenderImpl javaMailSenderImpl()
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.setUsername(emailUsername);
        mailSender.setPassword(emailPassword);
        mailSender.setDefaultEncoding("UTF-8");
        return mailSender;
    }

    @Bean
    public ResourceLoader resourceLoader()
    {
        return new DefaultResourceLoader();
    }
}