package ca.yorku.eecs.mack.democamera;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class DeleteAlertDialog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
                myListener.onDialogPositiveClick(DeleteAlertDialog.this);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
                myListener.onDialogNegativeClick(DeleteAlertDialog.this);
            }
        }).setTitle("DELETE! Are you sure?");
        return builder.create();
    }

    public interface DeleteAlertListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    DeleteAlertListener myListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            myListener = (DeleteAlertListener)activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }
}
