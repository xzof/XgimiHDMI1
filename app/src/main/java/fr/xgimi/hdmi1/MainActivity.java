package fr.xgimi.hdmi1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;

public class MainActivity extends Activity {
    private static final String HDMI1_URI =
        "content://android.media.tv/passthrough/com.droidlogic.tvinput%2F.services.Hdmi1InputService%2FHW5";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);
        layout.setBackgroundColor(Color.rgb(20, 24, 30));

        TextView title = new TextView(this);
        title.setText("XGIMI • Sélection de source");
        title.setTextColor(Color.WHITE);
        title.setTextSize(22);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 28);
        layout.addView(title);

        Button button = new Button(this);
        button.setText("Ouvrir HDMI 1");
        button.setTextSize(20);
        button.setAllCaps(false);
        button.setFocusable(true);
        button.setFocusableInTouchMode(true);
        button.setOnClickListener(v -> openHdmi1());
        layout.addView(button, new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView hint = new TextView(this);
        hint.setText("Appuyez sur OK pour basculer vers HDMI 1.");
        hint.setTextColor(Color.LTGRAY);
        hint.setTextSize(14);
        hint.setGravity(Gravity.CENTER);
        hint.setPadding(0, 24, 0, 0);
        layout.addView(hint);

        setContentView(layout);
        button.requestFocus();
    }

    private void openHdmi1() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(HDMI1_URI));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException | SecurityException e) {
            android.widget.Toast.makeText(this,
                "Impossible d'ouvrir HDMI 1 sur ce firmware.",
                android.widget.Toast.LENGTH_LONG).show();
        }
    }
}
