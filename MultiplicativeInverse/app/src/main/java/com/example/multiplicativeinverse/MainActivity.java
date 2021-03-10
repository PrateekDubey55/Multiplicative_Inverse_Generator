package com.example.multiplicativeinverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText num1, num2;
    private Button submitBtn;
    private TextView op;
    int n1,n2,min,max,gcd=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        submitBtn = findViewById(R.id.submitBtn);
        op = findViewById(R.id.op);

        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.submitBtn:
                if(num1.getText().toString().matches("") || num2.getText().toString().equals(""))
                {
                    op.setText("Input Field is Empty");
                }
                else {
                    modInverse();
                }
                break;
        }
    }

    private void modInverse() {
        n1=Integer.parseInt(num1.getText().toString());
        n2=Integer.parseInt(num2.getText().toString());
        min=n1;
        if(min>n2){
            min=n2;
            max=n1;
        }
        else{
            min=n1;
            max=n2;
        }
        while(max>min){
            int r = max%min;
            if(r==0){
                gcd=min;
                break;
            }
            else{
                max=min;
                min=r;
            }
        }
        if(gcd==1){
            for(int i=1;i<n2;i++){
                if((n1*i)%n2==1){
                    op.setText("Value of 'x' = "+String.valueOf(i));
                }
            }
        }
        else
        {
            op.setText("No such value of 'x' is possible since "+n1+" & "+n2+" are not co-prime");
        }
    }
}
