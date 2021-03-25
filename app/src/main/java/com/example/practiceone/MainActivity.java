package com.example.practiceone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class MainActivity extends BaseAct{
    private TextView tvLogin;
    private Button btTakePhoto,btDungDienThoai,btListView;

    private ImageView imageView;
    @Override
    protected void initViews() {
        tvLogin=findViewById(R.id.tvNhanDangNhap,this);
        imageView=findViewById(R.id.imageView);
        btDungDienThoai=findViewById(R.id.bt_dienthoai,this);
        btListView=findViewById(R.id.bt_chuyensangList,this);
        btTakePhoto=findViewById(R.id.button_take_photo,this);

        if(checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.CALL_PHONE
            }, 101);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if(requestCode==101){
            if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Please accepct this permission",Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tvNhanDangNhap) {
            showCustomDialog();
        }else if(v.getId()==R.id.button_take_photo){
            gotoGallery();
        }else if(v.getId()==R.id.bt_dienthoai){

            doCall();
        }else{
            gotoListView();
        }
    }

    private void gotoListView() {
        Intent intent=new Intent();
        intent.setClass(this,M002_Main_Act.class);
        startActivity(intent);
    }

    private void doCall() {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+"1900"));
            startActivity(intent);

    }

    private void gotoGallery() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,105);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri imgPath=data.getData();
            Glide.with(this).load(imgPath).into(imageView);
        }
    }

    private void showCustomDialog() {
        LoginDialog loginDialog=new LoginDialog(this);
        loginDialog.show();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }
}