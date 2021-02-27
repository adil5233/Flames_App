package com.jeelan.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = editText1.getText().toString();
                String s2 = editText2.getText().toString();
                int a= flamesCount(s1,s2);
                flamesResult(flamesCount(s1,s2));

            }
        });

    }

    private void flamesResult(int flamesCount) {
        String flames = "flames";
        int position;
        String temp;
        while (flames.length() != 1)
        {
            position = (flamesCount) % flames.length();
            if ( position != 0)
            {
                temp = flames.substring(position)+flames.substring(0,position-1);
            }
            else
            {
                temp = flames.substring(0,flames.length()-1);
            }
            flames = temp;
        }
         /*
        F	Friends
        L	Lovers
        A	Attraction
        M	Married
        E	Enemies
        S	Siblings
        */
        switch(flames)
        {
            case "f" : Toast.makeText(this.getApplicationContext(),"Friends",Toast.LENGTH_SHORT).show();
                break;
            case "l" : Toast.makeText(this.getApplicationContext(),"Love",Toast.LENGTH_SHORT).show();
                break;
            case "a": Toast.makeText(this.getApplicationContext(),"Attraction",Toast.LENGTH_SHORT).show();
                break;
            case "m": Toast.makeText(this.getApplicationContext(),"Married",Toast.LENGTH_SHORT).show();
                break;
            case "e" : Toast.makeText(this.getApplicationContext(),"Enemy",Toast.LENGTH_SHORT).show();
                break;
            case "s": Toast.makeText(this.getApplicationContext(),"Siblings",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    private static int flamesCount(String s1, String s2) {
        int length = s1.length()+s2.length();
        int count = 0;
        for (int i = 0;i<s1.length();i++)
        {
            for (int j = 0;j<s2.length();j++)
            {
                if(s1.charAt(i) == s2.charAt(j))
                {
                    count = count +1;
                    break;
                }
            }
        }
        return length - (count*2);
    }

}