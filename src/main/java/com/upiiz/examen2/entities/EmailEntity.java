package com.upiiz.examen2.entities;


public class EmailEntity {

    private String destinatario;
    private String asunto;
    private String mensaje;


    public EmailEntity()
    {

    }

    public EmailEntity(String destinatario, String asunto, String mensaje)
    {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getDestinatario()
    {
        return destinatario;
    }

    public String getAsunto()
    {
        return asunto;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setDestinatario(String destinatario)
    {
        this.destinatario = destinatario;
    }

    public void setAsunto(String asunto)
    {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }
    
}
