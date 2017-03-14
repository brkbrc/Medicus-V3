package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class ListDataDataSheet extends DataSheet {

    public ListDataDataSheet(Context context) {
        super(context, "listData");
        
        // This data sheet doesn't have local persistence enabled in Neonto Studio,
        // so write the default data each time.
        writeDefaultRowData();
    }
    
    @Override
    public String getName() {
        return "List data";
    }
    
    @Override
    protected void writeDefaultRowData() {
        ArrayList<HashMap<String, HashMap<String, Object>>> arr = new ArrayList<>();
        HashMap<String, HashMap<String, Object>> row;
        HashMap<String, Object> col;
        
        row = new HashMap<>();
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Ärzte suchen, Ärzte finden"); row.put("short description", col);
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Ärzte suchen"); row.put("title", col);
        col = new HashMap<>(); col.put("type", "image"); col.put("value", "asset://datasheet_listdata_row0_picture.jpg"); row.put("picture", col);
        arr.add(row);
        row = new HashMap<>();
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Schnelles Checkin in der Praxis"); row.put("short description", col);
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Checkin"); row.put("title", col);
        col = new HashMap<>(); col.put("type", "image"); col.put("value", "asset://datasheet_listdata_row1_picture.jpg"); row.put("picture", col);
        arr.add(row);
        row = new HashMap<>();
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Frage an den Support"); row.put("short description", col);
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Support"); row.put("title", col);
        col = new HashMap<>(); col.put("type", "image"); col.put("value", "asset://datasheet_listdata_row2_picture.jpg"); row.put("picture", col);
        arr.add(row);
        row = new HashMap<>();
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Bisherige Checkins verwalten."); row.put("short description", col);
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Vergangene Checkins"); row.put("title", col);
        col = new HashMap<>(); col.put("type", "image"); col.put("value", "asset://datasheet_listdata_row3_picture.jpg"); row.put("picture", col);
        arr.add(row);
        row = new HashMap<>();
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Ihre Einstellungen ändern Sie hier."); row.put("short description", col);
        col = new HashMap<>(); col.put("type", "text"); col.put("value", "Einstellungen"); row.put("title", col);
        col = new HashMap<>(); col.put("type", "image"); col.put("value", "asset://datasheet_listdata_row4_picture.jpg"); row.put("picture", col);
        arr.add(row);
        
        mRows = arr;
    }

}
