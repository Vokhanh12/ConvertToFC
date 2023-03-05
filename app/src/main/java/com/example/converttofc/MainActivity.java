package com.example.converttofc;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


class ThongBao{
    public ThongBao(Context context, String erro){
        AlertDialog.Builder thongbao = new AlertDialog.Builder(context)
                .setMessage(""+erro)
                .setTitle("Messanger")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog dialog = thongbao.create();

        dialog.show();

    }
}
public class MainActivity extends AppCompatActivity {

    private double Results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvFahrenheit,tvCelsius,tvFahrenheit1,tvCelsius1;
        Button btnChange,btnChange1;
        EditText edtFahrenheit,edtCelsius,edtFahrenheit1,edtCelsius1;

        tvFahrenheit =(TextView) findViewById(R.id.tvFahrenheit);
        tvCelsius=(TextView)findViewById(R.id.tvCelsius);
        tvFahrenheit1 =(TextView) findViewById(R.id.tvFahrenheit1);
        tvCelsius1=(TextView)findViewById(R.id.tvCelsius1);

        btnChange =(Button) findViewById(R.id.btnChange);
        btnChange1 =(Button) findViewById(R.id.btnChange1);


        edtFahrenheit =(EditText) findViewById(R.id.edtFahrenheit);
        edtCelsius =(EditText) findViewById(R.id.edtCelsius);
        edtFahrenheit1 =(EditText) findViewById(R.id.edtFahrenheit1);
        edtCelsius1 =(EditText) findViewById(R.id.edtCelsius1);





        //Convert to Celsius to Fahrenheit
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_edtFahrenheit =edtFahrenheit.getText().toString();
                String input_edtCelsius =edtCelsius.getText().toString();


                try{
                    Results = (Double.parseDouble(input_edtCelsius) * 1.8)+32;
                    edtFahrenheit.setText(""+Results);
                }
                catch (NumberFormatException ex){
                    ThongBao erro = new ThongBao(MainActivity.this,ex.toString());
                }
            }
        });

        //Convert to Fahrenheit to Celsius
        btnChange1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String input_edtFahrenheit1 =edtFahrenheit1.getText().toString();
                String input_edtCelsius1 =edtCelsius1.getText().toString();
                try{
                    Results = (Double.parseDouble(input_edtFahrenheit1)-32)*5/9;
                    edtCelsius1.setText(""+Results);
                }
                catch (NumberFormatException ex){
                    ThongBao erro = new ThongBao(MainActivity.this,ex.toString());
                }
            }
        });

    }
}