package model;

import service.IdGenerator;

public class BaseModel {
    private int id;

    public BaseModel() {
        this.id = IdGenerator.getIdGenerator().generateId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
