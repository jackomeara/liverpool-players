package com.example.ca;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * This activity displays basic information about a player, as well as an image of them.
 * Career stats for the club are shown, as well as a Read More button where they can read the
 * player's biography
 */
public class PlayerActivity extends AppCompatActivity {

    Context context;
    TextView name = null;
    TextView position = null;
    TextView goals = null;
    TextView appearances = null;
    TextView assists = null;
    ImageView image = null;
    Button bioButton = null;
    int playerIndex = 0;
    PlayerParser playerParser = null;
    List<Player> playerList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        playerParser = new PlayerParser(this);
        playerList = playerParser.getPlayers();

        name = findViewById(R.id.playerName);
        position = findViewById(R.id.playerProfilePosition);
        image = findViewById(R.id.playerProfileImage);
        appearances = findViewById(R.id.appearancesValue);
        goals = findViewById(R.id.goalsValue);
        assists = findViewById(R.id.assistsValue);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        playerIndex = (int) bundle.getSerializable("playerIndex");

        name.setText(playerList.get(playerIndex).getName());
        position.setText(playerList.get(playerIndex).getPosition());
        int imageResource = getResources().getIdentifier(playerList.get(playerIndex).getImage(), "drawable", getPackageName());
        image.setImageResource(imageResource);
        appearances.setText(playerList.get(playerIndex).getAppearances());
        assists.setText(playerList.get(playerIndex).getAssists());
        goals.setText(playerList.get(playerIndex).getGoals());

        bioButton = (Button)findViewById(R.id.openBio);
        bioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerActivity.this, BioActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("playerIndex", playerIndex);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
