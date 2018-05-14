package com.qam.departement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Departement dept;
    private SQLiteDatabase db;


    private EditText txtSearch;
    private EditText txtNoDept;
    private EditText txtNoRegion;
    private EditText txtNom;
    private EditText txtNomStd;
    private EditText txtSurface;
    private EditText txtDateCreation;
    private EditText txtChefLieu;
    private EditText txtUrlWiki;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dept= new Departement(this);

        txtSearch = (EditText) findViewById(R.id.txtSearch);
        txtNoDept = (EditText) findViewById(R.id.txtNoDept);
        txtNoRegion = (EditText) findViewById(R.id.txtNoRegion);
        txtNom = (EditText) findViewById(R.id.txtNom);
        txtNomStd = (EditText) findViewById(R.id.txtNomStd);
        txtSurface = (EditText) findViewById(R.id.txtSurface);
        txtDateCreation = (EditText) findViewById(R.id.txtDateCreation);
        txtChefLieu = (EditText) findViewById(R.id.txtChefLieu);
        txtUrlWiki = (EditText) findViewById(R.id.txtUrlWiki);
    }

    public void btnSearch(View view) {

        try {
            dept.select(txtSearch.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        txtNoDept.setText(dept.getNoDept());
        txtNoRegion.setText(dept.getNoRegion().toString());
        txtNom.setText(dept.getNom());
        txtNomStd.setText(dept.getNomStd());
        txtSurface.setText(dept.getSurface().toString());
        txtDateCreation.setText(dept.getDateCreation());
        txtChefLieu.setText(dept.getChefLieu());
        txtUrlWiki.setText(dept.getUrlWiki());
    }


    public void btnClear(View view) {
            txtSearch.setText("");
            txtNoDept.setText("");
            txtNoRegion.setText("");
            txtNom.setText("");
            txtNomStd.setText("");
            txtSurface.setText("");
            txtDateCreation.setText("");
            txtChefLieu.setText("");
            txtUrlWiki.setText("");
        }


    public void btnDelete(View view) {

    }

    public void btnSave(View view) {
    }

    public void btInsert (View v){
        try {
            dept.setNoDept(txtNoDept.getText().toString());
            dept.setNoRegion(txtNoRegion.getText().toString());
            dept.setNoDept(txtNom.getText().toString());
            dept.setNoDept(txtNomStd.getText().toString());
            dept.setNoDept(txtSurface.getText().toString());
            dept.setNoDept(txtDateCreation.getText().toString());
            dept.setNoDept(txtChefLieu.getText().toString());
            dept.setNoDept(txtUrlWiki.getText().toString());

            dept.insert();
        }
        catch (Exception e){
            Toast.makeText(this, "erreur: "+ e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}
