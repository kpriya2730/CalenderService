package model;

import java.util.Date;
import java.util.List;

public class Slot extends BaseModel{

    private Date startTime;
    private Date endTime;
    private SlotType type;
    public Slot(Date startTime, Date endTime, SlotType type) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }
}
