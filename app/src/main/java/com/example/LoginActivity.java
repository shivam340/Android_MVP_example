package com.example;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  implements IAfterLoginActions{

    @Bind(R.id.password)
    EditText password;

    @Bind(R.id.email)
    EditText email;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);

        if (BuildConfig.DEBUG){
            password.setText("demo");
            email.setText("demo@gmail.com");
        }

    }


    @OnClick(R.id.email_sign_in_button)
    public void onLogin(View view){
        Toast.makeText(LoginActivity.this, "Logging in please wait....", Toast.LENGTH_SHORT).show();
        loginPresenter.doLoginProcedure( email.getText().toString(), password.getText().toString());
    }

    @Override
    public void showNextScreen(String greetMessage) {
        Toast.makeText(LoginActivity.this, greetMessage, Toast.LENGTH_SHORT).show();
        //TODO: 27/02/16  start next activity.
    }

    @Override
    public void showFailedScreen(String status) {
        Toast.makeText(LoginActivity.this, status, Toast.LENGTH_SHORT).show();
        // TODO: 27/02/16   show failed login ui.
    }
}

