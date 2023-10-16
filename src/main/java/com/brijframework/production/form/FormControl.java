package com.brijframework.production.form;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FormControl {
    private String id;
    private List<FieldControl> fields = new ArrayList<FieldControl>();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<FieldControl> getFields() {
        return fields;
    }
    public void setFields(List<FieldControl> fields) {
        this.fields = fields;
    }
}