package android.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Register extends AppCompatActivity {
    EditText Username;
    EditText Email;
    EditText Password;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        Username = (EditText) findViewById(R.id.name);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
    }
    private void saveUsersInfo(){
        sharedPreferences = getSharedPreferences("UsersInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", Username.getText().toString());
        editor.putString("Email", Email.getText().toString());
        editor.putString("Password", Password.getText().toString());
        editor.commit();
    }
    public void BTN_Register(View view){
        if(Username.getText().toString() != "" && Email.getText().toString() != "" && Password.getText().toString() != ""){
            saveUsersInfo();
            new AlertDialog.Builder(Register.this)
                    .setTitle("hint")
                    .setMessage("Registered successfully!")
                    .setPositiveButton("确定", null).show();
            finish();
        }
        else{
            new AlertDialog.Builder(Register.this)
                    .setTitle("hint")
                    .setMessage("Error!")
                    .setPositiveButton("确定", null).show();
        }
    }
    public void BTN_ReturnLog(View view){
       finish();
    }
}
