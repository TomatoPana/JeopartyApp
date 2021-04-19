package com.mdlozano.jeoparty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int puntaje;

    Button btnCat1_100;
    Button btnCat2_100;
    Button btnCat3_100;
    Button btnCat4_100;
    Button btnCat1_200;
    Button btnCat2_200;
    Button btnCat3_200;
    Button btnCat4_200;
    Button btnCat1_300;
    Button btnCat2_300;
    Button btnCat3_300;
    Button btnCat4_300;
    Button btnCat1_400;
    Button btnCat2_400;
    Button btnCat3_400;
    Button btnCat4_400;
    Button btnCat1_500;
    Button btnCat2_500;
    Button btnCat3_500;
    Button btnCat4_500;
    Button btnCat1_600;
    Button btnCat2_600;
    Button btnCat3_600;
    Button btnCat4_600;

    TextView txtPuntaje;

    Hashtable<String, Hashtable<String, List<String>>> globalData;

    List<Hashtable<String, Boolean>> ultimosMovimientos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ultimosMovimientos = new ArrayList<>();

        Hashtable<String, Boolean> emptyData = new Hashtable<>();
        emptyData.put("1", false);

        ultimosMovimientos.add(emptyData);
        ultimosMovimientos.add(emptyData);

        this.globalData = createData();

        this.txtPuntaje = findViewById(R.id.txtPuntaje);
        this.btnCat1_100 = findViewById(R.id.btnCat1_100);
        this.btnCat2_100 = findViewById(R.id.btnCat2_100);
        this.btnCat3_100 = findViewById(R.id.btnCat3_100);
        this.btnCat4_100 = findViewById(R.id.btnCat4_100);
        this.btnCat1_200 = findViewById(R.id.btnCat1_200);
        this.btnCat2_200 = findViewById(R.id.btnCat2_200);
        this.btnCat3_200 = findViewById(R.id.btnCat3_200);
        this.btnCat4_200 = findViewById(R.id.btnCat4_200);
        this.btnCat1_300 = findViewById(R.id.btnCat1_300);
        this.btnCat2_300 = findViewById(R.id.btnCat2_300);
        this.btnCat3_300 = findViewById(R.id.btnCat3_300);
        this.btnCat4_300 = findViewById(R.id.btnCat4_300);
        this.btnCat1_400 = findViewById(R.id.btnCat1_400);
        this.btnCat2_400 = findViewById(R.id.btnCat2_400);
        this.btnCat3_400 = findViewById(R.id.btnCat3_400);
        this.btnCat4_400 = findViewById(R.id.btnCat4_400);
        this.btnCat1_500 = findViewById(R.id.btnCat1_500);
        this.btnCat2_500 = findViewById(R.id.btnCat2_500);
        this.btnCat3_500 = findViewById(R.id.btnCat3_500);
        this.btnCat4_500 = findViewById(R.id.btnCat4_500);
        this.btnCat1_600 = findViewById(R.id.btnCat1_600);
        this.btnCat2_600 = findViewById(R.id.btnCat2_600);
        this.btnCat3_600 = findViewById(R.id.btnCat3_600);
        this.btnCat4_600 = findViewById(R.id.btnCat4_600);

        this.puntaje = 0;

        txtPuntaje.setText(String.format(getResources().getString(R.string.txtPuntaje), puntaje));

    }

    public Hashtable<String, Hashtable<String, List<String>>> createData(){
        Hashtable<String, Hashtable<String, List<String>>> categorias = new Hashtable<>();

        List<String> pregunta01 = new ArrayList<>(Arrays.asList("01. ¿Cuanto es 2 + 2?",             "4",  "3",  "2",  "1"));
        List<String> pregunta02 = new ArrayList<>(Arrays.asList("01. ¿Cuanto es 2 * 2?",             "2",  "1",  "4",  "3"));
        List<String> pregunta03 = new ArrayList<>(Arrays.asList("01. ¿Cuanto es 2 * 10?",            "12", "20", "22", "2"));
        List<String> pregunta04 = new ArrayList<>(Arrays.asList("01. ¿Cuanto es 10 * 10?",           "100","20", "0",  "1"));
        List<String> pregunta05 = new ArrayList<>(Arrays.asList("01. ¿Cuanto es 10 * 10 + 10",       "200","10", "110","3"));
        List<String> pregunta06 = new ArrayList<>(Arrays.asList("01. ¿Cuanto es 10 * 10 / 10 + 10?", "20", "220","0",  "1"));
        List<String> pregunta07 = new ArrayList<>(Arrays.asList("02. ¿Cuanto es 2 + 2?",             "4",  "3",  "2",  "1"));
        List<String> pregunta08 = new ArrayList<>(Arrays.asList("02. ¿Cuanto es 2 * 2?",             "2",  "1",  "4",  "3"));
        List<String> pregunta09 = new ArrayList<>(Arrays.asList("02. ¿Cuanto es 2 * 10?",            "12", "20", "22", "2"));
        List<String> pregunta10 = new ArrayList<>(Arrays.asList("02. ¿Cuanto es 10 * 10?",           "100","20", "0",  "1"));
        List<String> pregunta11 = new ArrayList<>(Arrays.asList("02. ¿Cuanto es 10 * 10 + 10",       "200","10", "110","3"));
        List<String> pregunta12 = new ArrayList<>(Arrays.asList("02. ¿Cuanto es 10 * 10 / 10 + 10?", "20", "220","0",  "1"));
        List<String> pregunta13 = new ArrayList<>(Arrays.asList("03. ¿Cuanto es 2 + 2?",             "4",  "3",  "2",  "1"));
        List<String> pregunta14 = new ArrayList<>(Arrays.asList("03. ¿Cuanto es 2 * 2?",             "2",  "1",  "4",  "3"));
        List<String> pregunta15 = new ArrayList<>(Arrays.asList("03. ¿Cuanto es 2 * 10?",            "12", "20", "22", "2"));
        List<String> pregunta16 = new ArrayList<>(Arrays.asList("03. ¿Cuanto es 10 * 10?",           "100","20", "0",  "1"));
        List<String> pregunta17 = new ArrayList<>(Arrays.asList("03. ¿Cuanto es 10 * 10 + 10",       "200","10", "110","3"));
        List<String> pregunta18 = new ArrayList<>(Arrays.asList("03. ¿Cuanto es 10 * 10 / 10 + 10?", "20", "220","0",  "1"));
        List<String> pregunta19 = new ArrayList<>(Arrays.asList("04. ¿Cuanto es 2 + 2?",             "4",  "3",  "2",  "1"));
        List<String> pregunta20 = new ArrayList<>(Arrays.asList("04. ¿Cuanto es 2 * 2?",             "2",  "1",  "4",  "3"));
        List<String> pregunta21 = new ArrayList<>(Arrays.asList("04. ¿Cuanto es 2 * 10?",            "12", "20", "22", "2"));
        List<String> pregunta22 = new ArrayList<>(Arrays.asList("04. ¿Cuanto es 10 * 10?",           "100","20", "0",  "1"));
        List<String> pregunta23 = new ArrayList<>(Arrays.asList("04. ¿Cuanto es 10 * 10 + 10",       "200","10", "110","3"));
        List<String> pregunta24 = new ArrayList<>(Arrays.asList("04. ¿Cuanto es 10 * 10 / 10 + 10?", "20", "220","0",  "1"));

        Hashtable<String, List<String>> categoria1 = new Hashtable<>();
        categoria1.put("100", pregunta01);
        categoria1.put("200", pregunta02);
        categoria1.put("300", pregunta03);
        categoria1.put("400", pregunta04);
        categoria1.put("500", pregunta05);
        categoria1.put("600", pregunta06);

        Hashtable<String, List<String>> categoria2 = new Hashtable<>();
        categoria2.put("100", pregunta07);
        categoria2.put("200", pregunta08);
        categoria2.put("300", pregunta09);
        categoria2.put("400", pregunta10);
        categoria2.put("500", pregunta11);
        categoria2.put("600", pregunta12);

        Hashtable<String, List<String>> categoria3 = new Hashtable<>();
        categoria3.put("100", pregunta13);
        categoria3.put("200", pregunta14);
        categoria3.put("300", pregunta15);
        categoria3.put("400", pregunta16);
        categoria3.put("500", pregunta17);
        categoria3.put("600", pregunta18);

        Hashtable<String, List<String>> categoria4 = new Hashtable<>();
        categoria4.put("100", pregunta19);
        categoria4.put("200", pregunta20);
        categoria4.put("300", pregunta21);
        categoria4.put("400", pregunta22);
        categoria4.put("500", pregunta23);
        categoria4.put("600", pregunta24);

        categorias.put("1", categoria1);
        categorias.put("2", categoria2);
        categorias.put("3", categoria3);
        categorias.put("4", categoria4);

        return categorias;
    }

    public void onClickBtnCat(@NotNull View view){

        final int PREGUNTA = 0;
        final int RESPUESTA_1 = 1;
        final int RESPUESTA_2 = 2;
        final int RESPUESTA_3 = 3;
        final int RESPUESTA_CORRECTA = 4;



        Pattern p = Pattern.compile("^[a-z.:/]*btnCat([0-9])_([0-9]{3})$");

        Matcher m = p.matcher(view.getResources().getResourceName(view.getId()));

        if(m.matches()) {

            String categoria = m.group(1);
            String puntaje = m.group(2);

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("Pregunta", globalData.get(categoria).get(puntaje).get(PREGUNTA));
            intent.putExtra("Respuesta1", globalData.get(categoria).get(puntaje).get(RESPUESTA_1));
            intent.putExtra("Respuesta2", globalData.get(categoria).get(puntaje).get(RESPUESTA_2));
            intent.putExtra("Respuesta3", globalData.get(categoria).get(puntaje).get(RESPUESTA_3));
            intent.putExtra("RespuestaCorrecta", globalData.get(categoria).get(puntaje).get(RESPUESTA_CORRECTA));
            intent.putExtra("Categoria", categoria);
            intent.putExtra("Puntaje", puntaje);
            startActivityForResult(intent, 0);

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Hashtable<String, Boolean> info = new Hashtable<>();
        if (resultCode == RESULT_OK) {
            String Categoria = data.getStringExtra("Categoria");
            String Puntaje = data.getStringExtra("Puntaje");
            String button = "com.mdlozano.jeoparty:id/btnCat" + Categoria + "_" + Puntaje;
            if(data.getBooleanExtra("RespuestaCorrecta", false)){
                puntaje = puntaje + Integer.parseInt(Puntaje);
                txtPuntaje.setText(String.format(getResources().getString(R.string.txtPuntaje), puntaje));
                int resource = getResources().getIdentifier(button, null, null);
                Button editButton = findViewById(resource);
                editButton.setBackgroundColor(getResources().getColor(R.color.correcto));
                editButton.setEnabled(false);

                info.put(Categoria, true);

                ultimosMovimientos.set(0, ultimosMovimientos.get(1));
                ultimosMovimientos.set(1, info);

            } else {
                int resource = getResources().getIdentifier(button, null, null);
                Button editButton = findViewById(resource);
                if(!(ultimosMovimientos.get(0).containsValue(true) && ultimosMovimientos.get(1).containsValue(true) && !ultimosMovimientos.get(0).containsKey(Categoria) && !ultimosMovimientos.get(1).containsKey(Categoria))){
                    editButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_error));
                    editButton.setEnabled(false);
                }

                info.put(Categoria, false);

                ultimosMovimientos.set(0, ultimosMovimientos.get(1));
                ultimosMovimientos.set(1, info);

            }
        }
    }
}