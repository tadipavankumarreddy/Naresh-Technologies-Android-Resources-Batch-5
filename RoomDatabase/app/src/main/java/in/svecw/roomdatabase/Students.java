package in.svecw.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity/*(tableName = "students")*/
public class Students {
    @PrimaryKey(autoGenerate = true)
    int s_id;
    /*@ColumnInfo(name = "student_name")*/
    String s_name;
    int s_age;

    public Students(String s_name, int s_age) {
        this.s_name = s_name;
        this.s_age = s_age;
    }

    public int getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public int getS_age() {
        return s_age;
    }
}
