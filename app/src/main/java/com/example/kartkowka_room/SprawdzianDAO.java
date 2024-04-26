package com.example.kartkowka_room;

import android.widget.EditText;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface SprawdzianDAO {
    @Insert
    public void wstawDO(Sprawdzian sprawdzian);

    @Insert
    public void kilkaWstaw(Sprawdzian ... sprawdziany);

    @Query("SELECT * FROM sprawdziany")
    public List<Sprawdzian> wypiszSprawdziany();

    @Query("SELECT * FROM sprawdziany WHERE nazwa_spr == :podanaNazwa")
    public List<Sprawdzian> wypiszWszystkieSprawdzianyOdNazwy(String podanaNazwa);
}
