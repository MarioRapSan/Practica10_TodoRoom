package example.khraisat.com.roomexample;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import example.khraisat.com.roomexample.model.ToDoModel;

/**
 * Created by Ayat khraisat  on 6/10/2018.
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: RoomExample
 * <p>
 * Blessed Tree IT
 */
public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {

    private ArrayList<ToDoModel> toDoList;
    private Context context;

    public interface DeleteButtonClickListener {
        void onDeleteClick(ToDoModel toDoModel);
    }

    private DeleteButtonClickListener deleteButtonClickListener;

    public ToDoListAdapter(Context context, DeleteButtonClickListener deleteButton) {
        this.context = context;
        toDoList = new ArrayList<>();
        this.deleteButtonClickListener = deleteButton;
    }

    @Override
    public ToDoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_to_do, parent, false);

        return new ToDoListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ToDoModel toDo = toDoList.get(position);

        holder.toDoTextView.setText(toDo.getToDo());
        holder.toDoKeyTextView.setText(String.format("ToDo #%d", toDo.getToDoId()));

        int labelResource;
        int colorResource;
        switch (toDo.getPriority()) {
            case ToDoModel.PRIORITY_HIGH:
                labelResource = R.string.priority_high;
                colorResource = R.color.priorityHigh;
                break;
            case ToDoModel.PRIORITY_LOW:
                labelResource = R.string.priority_low;
                colorResource = R.color.priorityLow;
                break;
            default:
                labelResource = R.string.priority_medium;
                colorResource = R.color.priorityMedium;
                break;
        }
        holder.priorityTextView.setText(labelResource);
        holder.priorityTextView.setTextColor(ContextCompat.getColor(context, colorResource));
    }

    public void setToDoList(ArrayList<ToDoModel> toDoList) {
        if (this.toDoList == toDoList) {
            return;
        }
        this.toDoList.clear();
        if (toDoList != null) {
            this.toDoList.addAll(toDoList);
        }
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (toDoList == null)
            return 0;
        return toDoList.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView toDoTextView;
        private TextView toDoKeyTextView;
        private TextView priorityTextView;
        private Button deleteButton;

        public ViewHolder(View view) {
            super(view);
            toDoTextView = view.findViewById(R.id.tv_to_do);
            toDoKeyTextView = view.findViewById(R.id.tv_to_do_key);
            priorityTextView = view.findViewById(R.id.tv_priority);
            deleteButton = view.findViewById(R.id.btn_delete);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteButtonClickListener.onDeleteClick(
                            toDoList.get(getAdapterPosition()));
                }
            });
        }
    }

}
