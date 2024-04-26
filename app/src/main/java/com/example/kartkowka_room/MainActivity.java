package com.example.kartkowka_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nazwaPrzedmiot;
    private EditText zakresSprawdz;
    private EditText dataSprawdzianu;
    private List<Sprawdzian> sprawdziany;
    private ListView listaPrzedmiotow;
    private EditText ktoryPrzedmiot;
    private Button dodajPrzycisk;
    private Button pokazGuzik;
    private ArrayAdapter<Sprawdzian> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nazwaPrzedmiot = findViewById(R.id.przedmiotName);
        zakresSprawdz = findViewById(R.id.zakres);
        dataSprawdzianu = findViewById(R.id.dataPodaj);
        listaPrzedmiotow = findViewById(R.id.listaSpraw);
        pokazGuzik = findViewById(R.id.pokazGuzik);
        dodajPrzycisk = findViewById(R.id.button);
        ktoryPrzedmiot = findViewById(R.id.jakiprzedmiot);
        dbSpr bazaSpr = dbSpr.zwrocElement(getApplicationContext());


        dodajPrzycisk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nazwa = nazwaPrzedmiot.getText().toString();
                        String zakres = zakresSprawdz.getText().toString();
                        String data = dataSprawdzianu.getText().toString();
                        Sprawdzian spr = new Sprawdzian(nazwa,zakres,data);
                        bazaSpr.getSprawdzianDAO().wstawDO(spr);
                    }
                }
        );

        pokazGuzik.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String przedmiot = ktoryPrzedmiot.getText().toString();
                        sprawdziany = bazaSpr.getSprawdzianDAO().wypiszWszystkieSprawdzianyOdNazwy(przedmiot);
                        adapter = new ArrayAdapter<>(
                                getApplicationContext(), android.R.layout.simple_list_item_1,sprawdziany
                        );
                        listaPrzedmiotow.setAdapter(adapter);
                    }
                }
        );

    }
}