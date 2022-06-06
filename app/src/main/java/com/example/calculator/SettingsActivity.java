package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity implements Constants{
    private Button btnLightTheme, btnDarkTheme, btnBack;
    private Resources.Theme currentTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();
    }

    private void initViews() {
        btnLightTheme = findViewById(R.id.btnLightTheme);
        btnDarkTheme = findViewById(R.id.btnDarkTheme);
        btnBack = findViewById(R.id.btnBack);
        initOnclickListeners();
    }

    private void initOnclickListeners() {

        btnLightTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                intentResult.putExtra(APP_THEME, R.style.AppThemeLight);
            }
        });

        btnDarkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                intentResult.putExtra(APP_THEME, R.style.AppThemeDark);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}