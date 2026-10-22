package example.khraisat.com.roomexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import example.khraisat.com.roomexample.model.ToDoModel;
import example.khraisat.com.roomexample.room.DataBaseManager;

public class ToDoListActivity extends AppCompatActivity implements AddToDoInterface, ToDoListAdapter.DeleteButtonClickListener {

    public static final String ADD_TO_DO_DIALOG = "add-to-do-dialog";
    private ToDoListAdapter toDoListAdapter;
    private RecyclerView toDoRecyclerView;
    private DataBaseManager dataBaseManager;
    private FloatingActionButton addFloatingActionButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBaseManager = new DataBaseManager(this);
        setContentView(R.layout.activity_to_do_list);
        toDoRecyclerView = findViewById(R.id.rv_todo);
        addFloatingActionButton = findViewById(R.id.fab_add_todo);
        toDoListAdapter = new ToDoListAdapter(this, this);

        addFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AddToDoDialog addToDoDialog = new AddToDoDialog();

                addToDoDialog.setAddToDoInterface(ToDoListActivity.this);
                addToDoDialog.show(getSupportFragmentManager(), ADD_TO_DO_DIALOG);
            }
        });
        toDoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        toDoRecyclerView.setAdapter(toDoListAdapter);
        loadToDos();
    }

    private void loadToDos() {
        ArrayList<ToDoModel> toDoModelArrayList = dataBaseManager.getData();
        toDoListAdapter.setToDoList(toDoModelArrayList);
    }

    @Override
    public void onSaveClick(String toDo, int priority) {
        ToDoModel toDoModel = new ToDoModel(toDo, priority);
        dataBaseManager.saveItemToDataBase(toDoModel);
        loadToDos();
    }


    @Override
    public void onDeleteClick(ToDoModel toDoModel) {
        dataBaseManager.remove(toDoModel);
        loadToDos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
