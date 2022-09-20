package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int cursor;
    private EditText operacion;
    private TextView resultado;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPoint;
    private Button btnDelete;
    private Button btnSum;
    private Button btnRes;
    private Button btnMult;
    private Button btnDiv;
    private Button btnIgual;
    private Button btnClear;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operacion=findViewById(R.id.Operation);
        operacion.setShowSoftInputOnFocus(false);


        resultado=findViewById(R.id.Result);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnPoint=findViewById(R.id.btnPoint);
        btnDelete=findViewById(R.id.btnDelete);
        btnSum=findViewById(R.id.btnSuma);
        btnRes=findViewById(R.id.btnResta);
        btnMult=findViewById(R.id.btnMult);
        btnDiv=findViewById(R.id.btnDiv);
        btnIgual=findViewById(R.id.btnIgual);
        btnClear=findViewById(R.id.btnClear);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnRes.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnClear) {
            operacion.setText("");
            resultado.setText("0");
        }
        else if (view.getId()==R.id.btnIgual){
            try {
                Expression e= new ExpressionBuilder(operacion.getText().toString()).build();
                double result = e.evaluate();
                resultado.setText(Double.toString(result));
            }
            catch (RuntimeException e){
                resultado.setText(e.getMessage());
            }
        }
        else if (view.getId()==R.id.btnDelete){
            String str=operacion.getText().toString();
            cursor=operacion.getSelectionEnd();

            if (str.length() >=1 && cursor!=0) {
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(cursor-1);
                operacion.setText(sb.toString());
                cursor-=1;
                operacion.setSelection(cursor);

            } else if (str.length() <=1 ) {
                operacion.setText("");
                operacion.setSelection(operacion.length());
            }
        }
        else{
            Button btn=findViewById(view.getId());
            String str=operacion.getText().toString();
            StringBuilder sb = new StringBuilder(str);
            cursor=operacion.getSelectionEnd();
            sb.insert(cursor, btn.getText().toString());
            operacion.setText(sb.toString());
            cursor+=1;
            operacion.setSelection(cursor);
        }

    }


}




