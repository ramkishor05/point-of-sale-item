package com.brijframework.production.form;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FieldControl {
    private String key;
    private String name;
    private String label;
    private String type;
    private List<Object> items;
    private String itemKey;
    private String itemVal;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<Object> getItems() {
        return items;
    }
    public void setItems(List<Object> items) {
        this.items = items;
    }
    public String getItemKey() {
        return itemKey;
    }
    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }
    public String getItemVal() {
        return itemVal;
    }
    public void setItemVal(String itemVal) {
        this.itemVal = itemVal;
    }
}
