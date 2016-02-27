package com.example;

/**
 * Created by shivam on 27/02/16.
 */
public interface ILoginPresenter {
    public void success(String greetMessage);
    public void failed(String reason);
}
