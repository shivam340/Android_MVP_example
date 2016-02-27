package com.example;

/**
 * Created by shivam on 27/02/16.
 */
public class LoginPresenter implements ILoginPresenter {

    private IAfterLoginActions loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenter(IAfterLoginActions loginView){
        this.loginView = loginView;
        loginInteractor = new LoginInteractor(this);
    }

    @Override
    public void success(String greetMessage) {
        loginView.showNextScreen(greetMessage);
    }

    @Override
    public void failed(String reason) {
        loginView.showFailedScreen(reason);
    }

    public void doLoginProcedure(String email, String password) {
            loginInteractor.checkLogin(email, password);
    }
}

