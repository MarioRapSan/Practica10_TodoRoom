package example.khraisat.com.roomexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import example.khraisat.com.roomexample.model.ToDoModel;

/**
 * Created by Ayat khraisat  on 6/10/2018.
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: RoomExample
 * <p>
 * Blessed Tree IT
 */
public class AddToDoDialog extends DialogFragment {


    private EditText toDoEditText;
    private RadioGroup priorityRadioGroup;
    private AddToDoInterface addToDoInterface;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View root = inflater.inflate(R.layout.dialog_add_todo, null);
        toDoEditText = root.findViewById(R.id.et_todo);
        priorityRadioGroup = root.findViewById(R.id.rg_priority);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setPositiveButton(getContext()
                .getString(R.string.save), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addToDoInterface.onSaveClick(
                        toDoEditText.getText().toString(), getSelectedPriority());
            }
        });
        dialogBuilder.setNegativeButton(getContext()
                .getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialogBuilder.setView(root);
        return dialogBuilder.create();
    }

    private int getSelectedPriority() {
        int selected = priorityRadioGroup.getCheckedRadioButtonId();
        if (selected == R.id.rb_high) {
            return ToDoModel.PRIORITY_HIGH;
        }
        if (selected == R.id.rb_low) {
            return ToDoModel.PRIORITY_LOW;
        }
        return ToDoModel.PRIORITY_MEDIUM;
    }


    public void setAddToDoInterface(AddToDoInterface addToDoInterface) {
        this.addToDoInterface = addToDoInterface;
    }
}
