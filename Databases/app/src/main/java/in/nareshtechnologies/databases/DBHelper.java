package in.nareshtechnologies.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NareshTech";
    public static final String TABLE_NAME = "students";
    public static final String COL_0 = "students_id";
    public static final String COL_1 = "students_name";
    public static final String COL_2 = "students_age";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // we use onCreate(...) to create data base tables.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"("+COL_0+" integer primary key autoincrement, " +
                ""+COL_1+" text, "+COL_2+" integer);");
    }

    //onUpgrade method is useful if you want to release another version of your database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertData(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }


    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME,null,null);
    }

}
