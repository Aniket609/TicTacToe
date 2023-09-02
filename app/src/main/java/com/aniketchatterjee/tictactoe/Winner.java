package com.aniketchatterjee.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Winner extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        TextView congo = findViewById(R.id.cong);
        TextView result = findViewById(R.id.winner);
        Button multiP1First = findViewById(R.id.multiP1First);
        Button multiP2First= findViewById(R.id.multiP2first);
        Button singlePlay1st = findViewById(R.id.single_play1st);
        Button singlePlay2nd = findViewById(R.id.single_play2nd);
        String player1 = getIntent().getStringExtra("p1");
        String player2 = getIntent().getStringExtra("p2");
        String winner = getIntent().getStringExtra("result");

        assert winner != null;
        if (winner.equals("player1")){
            result.setText((player1 + " has won the game"));
        }
        else if (winner.equals("player2")){
            result.setText((player2 + " has won the game"));
        }
        else{
            congo.setText(("Well Played!"));
            result.setText(("It is a Draw!"));
        }

        multiP1First.setOnClickListener(view -> {
            Intent newGame = new Intent(Winner.this,Game.class);
            newGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle players = new Bundle();
            players.putString("p1", player1);
            players.putString("p2", player2);
            players.putString("mode", "1st");
            newGame.putExtras(players);
            startActivity(newGame);
        });
        multiP2First.setOnClickListener(view -> {
            Intent newGame = new Intent(Winner.this,Game.class);
            newGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle players = new Bundle();
            players.putString("p1", player1);
            players.putString("p2", player2);
            players.putString("mode", "2nd");
            newGame.putExtras(players);
            startActivity(newGame);
        });
        singlePlay1st.setOnClickListener(view -> {
            Intent newGame = new Intent(Winner.this,SinglePlayer.class);
            newGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle players = new Bundle();
            players.putString("p1", player1);
            players.putString("mode", "1st");
            newGame.putExtras(players);
            startActivity(newGame);
        });
        singlePlay2nd.setOnClickListener(view -> {
            Intent newGame = new Intent(Winner.this, SinglePlayer.class);
            newGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle players = new Bundle();
            players.putString("p1", player1);
            players.putString("mode", "2nd");
            newGame.putExtras(players);
            startActivity(newGame);
        });
    }
}
