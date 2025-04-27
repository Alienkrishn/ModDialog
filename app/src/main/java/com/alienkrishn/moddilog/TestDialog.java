package com.alienkrishn.moddilog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class TestDialog {

    public static void showDialog(final Context context) {
        // Create custom dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);

        // Set custom title view
        TextView titleView = new TextView(context);
        titleView.setText("Test Dialog");
        titleView.setTextColor(Color.WHITE);
        titleView.setTextSize(20);
        titleView.setPadding(40, 40, 40, 20);
        titleView.setBackgroundColor(Color.parseColor("#FF5722")); // Orange header
        builder.setCustomTitle(titleView);

        // Set message with custom style
        TextView messageView = new TextView(context);
        messageView.setText("This is a test dialogue made by Alienkrishn with AIDE app");
        messageView.setTextColor(Color.BLACK);
        messageView.setTextSize(16);
        messageView.setPadding(40, 30, 40, 30);
        builder.setView(messageView);

        // Create dialog instance
        final AlertDialog dialog = builder.create();

        // Set rounded corners
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface di) {
                    View view = dialog.getWindow().getDecorView();
                    GradientDrawable shape = new GradientDrawable();
                    shape.setCornerRadius(30); // Rounded corners
                    shape.setColor(Color.WHITE); // Background color
                    view.setBackground(shape);
                }
            });

        // Set buttons with colors
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", 
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Join", 
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, 
                                               Uri.parse("https://t.me/nullnmods"));
                    context.startActivity(intent);
                }
            });

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Exit", 
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (context instanceof Activity) {
                        ((Activity)context).finish();
                    }
                }
            });

        // Show dialog first to get buttons
        dialog.show();

        // Style buttons after showing
        styleButton(dialog.getButton(AlertDialog.BUTTON_POSITIVE), "#4CAF50"); // Green
        styleButton(dialog.getButton(AlertDialog.BUTTON_NEUTRAL), "#2196F3"); // Blue
        styleButton(dialog.getButton(AlertDialog.BUTTON_NEGATIVE), "#F44336"); // Red
    }

    private static void styleButton(Button button, String colorHex) {
        if (button != null) {
            button.setTextColor(Color.WHITE);
            button.setBackgroundColor(Color.parseColor(colorHex));

            // Rounded corners for button
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(40); // Very rounded
            shape.setColor(Color.parseColor(colorHex));
            button.setBackground(shape);

            // Padding
            button.setPadding(40, 15, 40, 15);
        }
    }
}
