package com.example.mipermissioncheck;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestSmsPermission();
    }

    private void requestSmsPermission() {
        Log.d("Test", "requestSmsPermission");
        String permission = Manifest.permission.READ_CONTACTS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }else {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
            Log.d("Test", "requestSmsPermission else");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("Test", "onRequestPermissionsResult");
        if (requestCode == 1) {
            if(grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("Test", "onRequestPermissionsResult if");
                    Toast.makeText(MainActivity.this, "permission granted", Toast.LENGTH_SHORT).show();


                } else {
                    Log.d("Test", "onRequestPermissionsResult else");
                    requestSmsPermission();
                    Toast.makeText(MainActivity.this, "permission not granted", Toast.LENGTH_SHORT).show();
                }
            }else  {
                Log.d("Test", "onRequestPermissionsResult second else");
            }
        }else{
            Log.d("Test", "onRequestPermissionsResult first else");
        }

    }
}
