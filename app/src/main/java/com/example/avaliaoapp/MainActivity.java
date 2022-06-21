package com.example.avaliaoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView resultadoCalculo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        resultadoCalculo = findViewById(R.id.textResultado);

    }


    public Boolean validateFields(String alcool, String gasolina){
       boolean isExist = true;

       if (alcool == null || alcool.equals("")){
           isExist = false;
       }
       else if (gasolina == null || gasolina.equals("")){
           isExist = false;
       }

       return isExist;
    }


    public void calcularMelhorPreco(String alcool, String gasolina){
        Double precoAlcool = Double.parseDouble(alcool);
        Double precoGasolina = Double.parseDouble(gasolina);

        if(precoAlcool < precoGasolina){
            resultadoCalculo.setText("O alcool está com um melhor preço no momento");
        }
        else if (precoAlcool > precoGasolina){
            resultadoCalculo.setText("A gasolina está com um melhor preço no momento");
        }
        else{
            resultadoCalculo.setText("Ambos possui o mesmo preço");
        }

    }

    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        if(validateFields(precoAlcool, precoGasolina)){
               calcularMelhorPreco(precoAlcool, precoGasolina);
        }
        else{
            resultadoCalculo.setText("Digite todas as informações necessarias!!!!!!");
        }
    }



}
