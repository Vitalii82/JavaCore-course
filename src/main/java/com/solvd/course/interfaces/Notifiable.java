package com.solvd.course.interfaces;
public interface Notifiable {
    void sendConfirmation(String msg);
    void sendFailure(String msg);
}
