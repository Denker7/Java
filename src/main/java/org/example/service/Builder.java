package org.example.service;

import org.example.model.Entity;
import org.example.model.Type;

public class Builder {
    private static Builder builder;

    private Builder() {
    }

    public static Builder getInstance() {
        if (builder == null) {
            builder = new Builder();
        }
        return builder;
    }

    public Entity build(String s){
        Entity entity;
        String sType = s.split("_")[0];
        String sOtherParam = s.split("_")[1];
        switch (sType){
            case ("C100"):
                entity = build(sOtherParam, Type.AUTO);
                break;
            case ("C200"):
                entity = buildOptional(sOtherParam, Type.CARGO);
                break;
            case ("C300"):
                entity = buildOptional(sOtherParam, Type.PASSANGER);
                break;
            case ("C400"):
                entity = buildOptional(sOtherParam, Type.HEAVY);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sType);
        }
        return entity;
    }

    private Entity build(String param, Type type){
        String[] arrStr = param.split("-");
        Entity entity = new Entity(type, arrStr[0], Integer.parseInt(arrStr[1]), null);
        return entity;
    }

    private Entity buildOptional(String param, Type type){
        String[] arrStr = param.split("-");
        Entity entity = new Entity(type, arrStr[0], Integer.parseInt(arrStr[1]), Integer.parseInt(arrStr[2]));
        return entity;
    }
}
