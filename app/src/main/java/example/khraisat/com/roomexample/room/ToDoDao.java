package example.khraisat.com.roomexample.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import example.khraisat.com.roomexample.model.ToDoModel;

/**
 * Created by Ayat khraisat  on 6/10/2018.
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: RoomExample
 * <p>
 * Blessed Tree IT
 */
@Dao
public interface ToDoDao {


    @Query("SELECT * FROM ToDoModel")
    List<ToDoModel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<ToDoModel> toDoList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(ToDoModel toDoModel);

    @Query("SELECT COUNT() FROM ToDoModel")
    int getNumberOfRows();

    @Query("DELETE FROM ToDoModel")
    void clearAll();

    @Delete
    void delete(ToDoModel toDoModel);


}
