package com.example;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by shivam on 27/02/16.
 */
public class LoginInteractor {


    ILoginPresenter listener;

    public LoginInteractor(ILoginPresenter listener){
        this.listener = listener;
    }

    public void checkLogin(final String email, final String password){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if ( !TextUtils.isEmpty(email) && email.contains("gmail")){
                    listener.success("Welcome");
                }else{
                    listener.failed("email id is invalid");
                }

            }
        }, 5000);


    }

}
