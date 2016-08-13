package org.configapp.dto;

import org.configapp.dto.*;
import java.util.*;

/**
 * Created by tulip_000 on 09/08/2016.
 */
public class ConfigDTO {

    private List<ParameterConfig> add;
    private List<String> remove;

    public List<ParameterConfig> getAdd() {
        return add;
    }

    public void setAdd(List<ParameterConfig> add) {
        this.add = add;
    }

    public List<String> getRemove() {
        return remove;
    }

    public void setRemove(List<String> remove) {
        this.remove = remove;
    }

    @Override
    public String toString() {
        return "ConfigDTO{" +
                "add=" + add +
                ", remove=" + remove +
                '}';
    }
}
