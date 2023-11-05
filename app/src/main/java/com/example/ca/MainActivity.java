package com.example.ca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView list = null;
    PlayerParser playerParser = null;
    List<Player> playerList = null;
    PlayerListAdapter playerListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerParser = new PlayerParser(this);
        playerList = playerParser.getPlayers();
        playerListAdapter = new PlayerListAdapter(this, R.layout.player_card, playerList, this);

        list = findViewById(R.id.recyclerView);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(playerListAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("playerIndex", position);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}