package android.example.myapplication;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
    }

    public void BTN_Create(View view){
        startActivity(new Intent(MainActivity.this,Register.class));
    }
    public void BTN_Login(View view){
        sharedPreferences = getSharedPreferences("UsersInfo", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("Email",null);
        String password = sharedPreferences.getString("Password",null);
        String Email = ((EditText) findViewById(R.id.email)).getText().toString();
        String Password = ((EditText)findViewById(R.id.password)).getText().toString();
        if((email.equals(Email) )  && (password.equals(Password))){
           startActivity(new Intent(MainActivity.this,Welcome.class));
        }else{
           new AlertDialog.Builder(MainActivity.this)
                    .setTitle("hint")
                    .setMessage("Error!")
                    .setPositiveButton("确定", null).show();
        }
    }

}
