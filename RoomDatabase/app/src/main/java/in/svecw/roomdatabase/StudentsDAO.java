package in.svecw.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentsDAO {

    @Insert
    void insertData(Students students);

    @Update
    void updateData(Students students);

    @Query("SELECT * from Students")
    List<Students> getAllData();
}
