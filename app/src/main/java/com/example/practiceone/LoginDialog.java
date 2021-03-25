package com.example.practiceone;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog  implements View.OnClickListener {
    public LoginDialog(@NonNull Context context) {
        super(context,R.style.Theme_AppCompat_Light);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dialog);
        //findViewById(R.id.bt_cancel).setOnClickListener(this);
        //setCancelable(false); ngăn chặn dismiss khi touch vào vùng back
        // ngăn chặn dismiss do touch vào vùng bên ngoài
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int width= ViewGroup.LayoutParams.MATCH_PARENT;
        int height=ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setLayout(width,height);
    }

    @Override
    public void onClick(View v) {
        
    }
}
