package com.example;

/**
 * Created by shivam on 27/02/16.
 */
public interface IAfterLoginActions {
    public void showNextScreen(String message);
    public void showFailedScreen(String reason);
}
