package com.example.ca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * The biography activity displays a brief text profile of the player.
 * It also has a button where the highlights of a player can be viewed (HighlightsWebViewActivity).
 */
public class BioActivity extends AppCompatActivity {
    TextView name = null;
    TextView bio = null;
    PlayerParser playerParser = null;
    List<Player> playerList = null;
    int playerIndex = 0;
    Button highlightsButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        playerParser = new PlayerParser(this);
        playerList = playerParser.getPlayers();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        playerIndex = (int) bundle.getSerializable("playerIndex");

        bio = findViewById(R.id.bioContent);
        name = findViewById(R.id.bioTitle);

        bio.setText(playerList.get(playerIndex).getBio());
        name.setText(playerList.get(playerIndex).getName());

        highlightsButton = (Button)findViewById(R.id.highlights);
        highlightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BioActivity.this, HighlightsWebViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("url", playerList.get(playerIndex).getUrl());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
