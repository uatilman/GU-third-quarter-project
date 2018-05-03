package ru.tilman.gb.ee.dto;

public class ResultRecord {

    private boolean success = true;

    public ResultRecord() {
        success=true;
    }

    public ResultRecord(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
