package org.configapp.dto;

/**
 * Created by tulip_000 on 09/08/2016.
 */
public class Greeting {


    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
