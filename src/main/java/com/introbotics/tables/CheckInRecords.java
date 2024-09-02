package com.introbotics.tables;

import java.time.LocalDateTime;

public class CheckInRecords {
    
    private int recordID, userID, tagID;
    private LocalDateTime checkInTime, checkOutTime;

    public CheckInRecords(int recordID, int userID, int tagID, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        this.recordID = recordID;
        this.userID = userID;
        this.tagID = tagID;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public void setRecordID(int ID) {
        this.recordID = ID;
    }

    public int getRecordID() {
        return this.recordID;
    }

    public void setUserID(int ID) {
        this.userID = ID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setTagID(int ID) {
        this.tagID = ID;
    }

    public int getTagID() {
        return this.tagID;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckInTime() {
        return this.checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public LocalDateTime getCheckOutTime() {
        return this.checkOutTime;
    }

}
