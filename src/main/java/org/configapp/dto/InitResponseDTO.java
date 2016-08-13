package org.configapp.dto;

/**
 * Created by tulip_000 on 09/08/2016.
 */
public class InitResponseDTO {

    private String idApp;
    private String messageError;

    public String getIdApp() {
        return idApp;
    }

    public void setIdApp(String idApp) {
        this.idApp = idApp;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
