package org.configapp.dto;

/**
 * Created by tulip_000 on 09/08/2016.
 */
public class ParameterConfig {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParameterConfig{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
