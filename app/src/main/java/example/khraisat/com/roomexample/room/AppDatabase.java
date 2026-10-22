package example.khraisat.com.roomexample.room;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import example.khraisat.com.roomexample.model.ToDoModel;

/**
 * Created by Ayat khraisat  on 4/23/2018.
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: National-Wallet
 * <p>
 * Blessed Tree IT
 */
@Database(entities = {ToDoModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ToDoDao toDoDao();

    /**
     * Añade la columna de prioridad a las bases de datos creadas con la versión 1.
     * Las tareas que ya existían se quedan con prioridad media.
     */
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(
                    "ALTER TABLE ToDoModel ADD COLUMN priority INTEGER NOT NULL DEFAULT 1");
        }
    };
}
