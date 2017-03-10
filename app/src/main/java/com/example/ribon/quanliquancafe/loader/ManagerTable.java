package com.example.ribon.quanliquancafe.loader;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ribon.quanliquancafe.model.Table;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 09/03/2017.
 */

public class ManagerTable extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.ribon.quanliquancafe/databases/";
    private static String DB_NAME = "ManagerCoffee.sqlite";
    private static final int DATABASE_VERSION=1;

    private SQLiteDatabase myDataBase;
    private final Context myContext;


    public ManagerTable(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        myContext=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){

        }

        if(checkDB != null)
            checkDB.close();

        return checkDB != null ? true :false;
    }

    private void copyDataBase() throws IOException {


        InputStream myInput = myContext.getAssets().open(DB_NAME);


        String outFileName = DB_PATH + DB_NAME;


        OutputStream myOutput = new FileOutputStream(outFileName);

        //truyen du lieu tu inputfile sang outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0)
        {
            myOutput.write(buffer, 0, length);
        }

        //Dong luon
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();

        if(dbExist){

        }
        else{
            this.getReadableDatabase();
            try {
                copyDataBase(); //chep du lieu
            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
    public List<Table> tableList()
    {   List<Table> tables = new ArrayList<Table>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from TableCoffee order by sort asc", null);
        cursor.moveToFirst();
        do{
            Table item=new Table();
            item.setId(cursor.getInt(0));
            item.setTableName(cursor.getString(1));
            item.setSort(cursor.getInt(2));
            tables.add(item);
        }while(cursor.moveToNext());
        return tables;
    }

    public boolean updateSort(int tableId, int pos){
        myDataBase=this.getReadableDatabase();
        try{
            myDataBase.execSQL("UPDATE TableCoffee SET sort = "+pos+" WHERE id = "+tableId);
            return true;
        }catch (Exception e){
            return false;
        }finally {
            myDataBase.close();
        }
    }


    public void insertData(){
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
