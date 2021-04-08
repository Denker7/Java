package org.example.model;

public class Entity extends Object{
    private Type type;
    private String gosNum;
    private Integer mileage;
    private Integer optionalParam;

    public Entity(Type type, String gosNum, Integer mileage, Integer optionalParam) {
        this.type = type;
        this.gosNum = gosNum;
        this.mileage = mileage;
        this.optionalParam = optionalParam;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getGosNum() {
        return gosNum;
    }

    public void setGosNum(String gosNum) {
        this.gosNum = gosNum;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getOptionalParam() {
        return optionalParam;
    }

    public void setOptionalParam(Integer optionalParam) {
        this.optionalParam = optionalParam;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "type=" + type.toString() +
                ", gosNum='" + gosNum + '\'' +
                ", mileage=" + mileage +
                ", optionalParam=" + optionalParam +
                '}';
    }
}
