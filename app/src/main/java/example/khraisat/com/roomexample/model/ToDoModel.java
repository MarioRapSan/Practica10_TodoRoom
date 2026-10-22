package example.khraisat.com.roomexample.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Ayat khraisat  on 6/10/2018.
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: RoomExample
 * <p>
 * Blessed Tree IT
 */
@Entity
public class ToDoModel {

    @PrimaryKey(autoGenerate = true)
    private int toDoId;

    private String toDo;


    public ToDoModel(String toDo) {
        this.toDo = toDo;
    }

    public int getToDoId() {
        return toDoId;
    }

    public void setToDoId(int toDoId) {
        this.toDoId = toDoId;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
