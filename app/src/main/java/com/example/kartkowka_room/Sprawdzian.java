package com.example.kartkowka_room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sprawdziany")

public class Sprawdzian {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "nazwa_spr")
    private String nazwa;
    private String zakres;
    private String data;

    public Sprawdzian(String nazwa, String zakres, String data) {
        id = 0;
        this.nazwa = nazwa;
        this.zakres = zakres;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Sprawdzian{" +
                "nazwa='" + nazwa + '\'' +
                ", zakres='" + zakres + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getZakres() {
        return zakres;
    }

    public void setZakres(String zakres) {
        this.zakres = zakres;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
