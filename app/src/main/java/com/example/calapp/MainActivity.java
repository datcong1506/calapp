package com.example.calapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTextView,solutionTextview;
    MaterialButton buttonC,bttonBRackOpen,buttonBrackClose;
    MaterialButton buttonDevice,buttonMul,buttonMinus,buttonPlus,buttonEqual;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAc,buttonDot;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView=findViewById(R.id.result_tv);
        solutionTextview=findViewById(R.id.solution_tv);




        assignId(buttonC,R.id.button_c);
        assignId(bttonBRackOpen,R.id.button_open_bracket);
        assignId(buttonBrackClose,R.id.button_close_bracket);
        assignId(buttonDevice,R.id.button_divide);
        assignId(buttonMul,R.id.button_multiply);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonEqual,R.id.button_equals);
        assignId(buttonPlus,R.id.button_plus);

        assignId(button0,R.id.button_0);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);

        assignId(buttonAc,R.id.button_ac);
        assignId(buttonDot,R.id.button_dot);



    }

    void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        MaterialButton button=(MaterialButton) view;
        String buttonText=button.getText().toString();
        String dataToCal=solutionTextview.getText().toString();

//        if(buttonText.equals("AC")){
//            solutionTextview.setText("");
//            resultTextView.setText("0");
//            return;
//        }
        if(buttonText.equals("=")){
            solutionTextview.setText(resultTextView.getText().toString());
            return;
        }
        if(buttonText.equals("C")){
            dataToCal=dataToCal.substring(0,dataToCal.length()-1);
        }else{
            dataToCal=dataToCal+buttonText;

        }





        solutionTextview.setText(dataToCal);
        solutionTextview.setText("sss");

        String finalRS=getResult(dataToCal);
        if(!finalRS.equals("Err")){
            resultTextView.setText(finalRS);


        }else{
        }


    }
    String getResult(String data){
//        Context context
        try {
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initSafeStandardObjects();
            String finalRS=context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            return finalRS;
        }catch (Exception e){
            return "Err";
        }

    }
}