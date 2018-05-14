package com.qam.departement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Departement {

    private SQLiteDatabase db;
    private Context c;

    private String noRegion;
    private String nom;
    private String nomStd;
    private String Surface;
    private String dateCreation;
    private String chefLieu;
    private String urlWiki;
    private String noDept;



    public Departement(SQLiteDatabase db) {
        this.db = db;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getNomStd() {
        return nomStd;
    }

    public void setNomStd(String nomStd) {
        this.nomStd = nomStd;
    }

    public String getSurface() {
        return Surface;
    }

    public void setSurface(String surface) {
        Surface = surface;
    }


    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }


    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }

    public String getNoDept() {
        return noDept;
    }

    public void setNoDept(String noDept) throws Exception {
        if (noDept.equals ("") ){
            throw new Exception("vide");
        }
        else if (Pattern.matches("[0-9]{2}|2A|2B|97[0-5]", noDept)){

        }else {
            this.noDept = noDept;
        }
    }

    public String getNoRegion() {
        return noRegion;
    }

    public void setNoRegion(String noRegion) {
        this.noRegion = noRegion;
    }

    public Departement (Context c){
        DbInit dbInit =new DbInit(c);
        db = dbInit.getWritableDatabase();

    }

    public void select (String no)throws Exception {
        String[] colums = new String[]{"no_dept","no_region","nom","nom_std","surface","date_creation","chef_lieu","url_wiki"};
        String critere = "no_dept ='"+no+"'";
        Cursor result = db.query("departements",colums,critere,null,"","","");
        if(result.getCount()<1){
            throw new Exception("Le depart n'espa pas present"+ no + "n'existe pas");
        }
        result.moveToFirst();
        noDept=result.getString(result.getColumnIndex("no_dept"));
        noRegion=String.valueOf(result.getString(result.getColumnIndex("no_region")));
        nom=result.getString(result.getColumnIndex("nom"));
        nomStd=result.getString(result.getColumnIndex("nom_std"));
        Surface=String.valueOf(result.getString(result.getColumnIndex("surface")));
        dateCreation=result.getString(result.getColumnIndex("date_creation"));
        chefLieu=result.getString(result.getColumnIndex("chef_lieu"));
        urlWiki=result.getString(result.getColumnIndex("url_wiki"));
    }
    public void insert(){
        ContentValues values = new ContentValues();
        values.put ("no_dept",noDept);
        values.put ("no_region",Integer.parseInt(noRegion));
        values.put ("nom",nom);
        values.put ("nom_std",nomStd);
        values.put ("surface", Integer.parseInt(Surface));
        values.put ("date_creation",dateCreation);
        values.put ("chef_lieu",chefLieu);
        values.put ("url_wiki",urlWiki);
        db.insert("departements",null,values);

    }
    public void update(){
        ContentValues values = new ContentValues();
        values.put ("no_dept",noDept);
        values.put ("no_region",Integer.parseInt(noRegion));
        values.put ("nom",nom);
        values.put ("nom_std",nomStd);
        values.put ("surface",Integer.parseInt(Surface));
        values.put ("date_creation",dateCreation);
        values.put ("chef_lieu",chefLieu);
        values.put ("url_wiki",urlWiki);
        String critere = "no_dep='"+ noDept+"'";
        db.insert("departements",null,values);
    }


}
