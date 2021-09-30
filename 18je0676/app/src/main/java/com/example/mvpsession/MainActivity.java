package com.example.mvpsession;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainContract.view {

    MainContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        presenter.end();
    }

    @Override
    public void start() {

    }

    @Override
    public void showToast(String ans) {
        Toast.makeText(this, ans, Toast.LENGTH_SHORT).show();
        presenter.dowMoreWork();
    }
}
