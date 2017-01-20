package com.androidmads.ajts.customsnackbar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Normal Snackbar", Snackbar.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Snackbar with Action", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Action!", Snackbar.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.RED).show();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar mSnackBar = Snackbar.make(v, "Snackbar with Custom Gravity", Snackbar.LENGTH_LONG);
                TextView mainTextView = (TextView) (mSnackBar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    mainTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                else
                    mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                mSnackBar.show();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar mSnackBar = Snackbar.make(v, "Custom Color", Snackbar.LENGTH_LONG);

                TextView mainTextView = (TextView) (mSnackBar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                TextView actionTextView = (TextView) (mSnackBar.getView()).findViewById(android.support.design.R.id.snackbar_action);

                // To Change Snackbar Color
                mSnackBar.getView().setBackgroundColor(Color.WHITE);

                // To Apply Custom Fonts for Message and Action
                Typeface font = Typeface.createFromAsset(getAssets(), "Lato-Regular.ttf");
                mainTextView.setTypeface(font);
                actionTextView.setTypeface(font);

                // To Change Text Color for Message and Action
                mainTextView.setTextColor(Color.BLACK);
                actionTextView.setTextColor(Color.BLACK);

                mSnackBar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Action!", Snackbar.LENGTH_SHORT).show();
                    }
                });
                mSnackBar.show();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar mSnackBar = Snackbar.make(v, "TOP SNACKBAR", Snackbar.LENGTH_LONG);
                View view = mSnackBar.getView();
                FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
                params.gravity = Gravity.TOP;
                view.setLayoutParams(params);
                view.setBackgroundColor(Color.RED);
                TextView mainTextView = (TextView) (view).findViewById(android.support.design.R.id.snackbar_text);
                mainTextView.setTextColor(Color.WHITE);
                mSnackBar.show();
            }
        });

    }
}
