package com.example.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
         EditText n,P;
         SharedPreferences sp;
         SharedPreferences.Editor editor;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.name);
        P=findViewById(R.id.pwd);
        sp=getSharedPreferences("myname",MODE_PRIVATE);
    }

    public void savedata(View view) {
        String Userid=n.getText().toString();
        String Password=P.getText().toString();
        Toast.makeText(this,""+Userid+"\n"+
                Password,Toast.LENGTH_SHORT).show();
        editor=sp.edit();
        editor.putString("key-name",Userid);
        editor.putString("key-password",Password);
        editor.commit();

    }

    public void Retrivedata(View view) {
        String s=sp.getString("key-name","");
        String s1=sp.getString("key-password","");
        n.setText(s);
        P.setText(s1);

    }
}
