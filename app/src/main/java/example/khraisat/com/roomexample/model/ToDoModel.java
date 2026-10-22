package example.khraisat.com.roomexample.model;

import androidx.room.ColumnInfo;
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

    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int PRIORITY_HIGH = 2;

    @PrimaryKey(autoGenerate = true)
    private int toDoId;

    private String toDo;

    @ColumnInfo(defaultValue = "1")
    private int priority = PRIORITY_MEDIUM;

    public ToDoModel() {
    }

    public ToDoModel(String toDo, int priority) {
        this.toDo = toDo;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
