package kakao.woo95.dbtestapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context) {
        super(context, "food.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table food(id Integer primary key AUTOINCREMENT, foodname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table food");
        onCreate(db);
    }

    public void addFood(Food food){
        ContentValues row = new ContentValues();
        row.put("foodname", food.get_foodName());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("food", null,row);
        db.close();
    }

    public Food findFood(int num){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from food where id="+num,null);

        Food food = new Food();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            food.set_id(Integer.parseInt(cursor.getString(0)));
            food.set_foodName(cursor.getString(1));
            cursor.close();
        } else {
            food = null;
        }
        db.close();
        return food;
    }

    public void deleteFood(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from food where id="+id);
    }
}
