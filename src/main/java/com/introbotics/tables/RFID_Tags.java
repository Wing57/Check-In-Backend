package com.introbotics.tables;

public class RFID_Tags {

    private int tag_id, user_id;
    private String rfidCode;

    public RFID_Tags(int tag_id, int user_id, String rfidCode) {
        this.tag_id = tag_id;
        this.user_id = user_id;
        this.rfidCode = rfidCode;
    }

    public void setTagID(int tagID) {
        this.tag_id = tagID;
    }

    public int getTagID() {
        return this.tag_id;
    }

    public void setCode(String RFIDCode) {
        this.rfidCode = RFIDCode;
    }

    public String getCode() {
        return this.rfidCode;
    }

    public String toString() {
        return "Tag ID: " + this.tag_id + "\n" +
                "RFID Code: " + this.rfidCode;
    }
    
}
