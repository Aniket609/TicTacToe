package com.aniketchatterjee.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText p1 = findViewById(R.id.p1);
        EditText p2 = findViewById(R.id.p2);
        Button multi = findViewById(R.id.multi);
        Button single = findViewById(R.id.single);

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1 = p1.getText().toString();
                String player2 = p2.getText().toString();
                Bundle players = new Bundle();
                players.putString("p1", player1);
                players.putString("p2", player2);
                players.putString("mode", "1st");
                Intent startGame = new Intent(MainActivity.this,Game.class);
                startGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startGame.putExtras(players);
                startActivity(startGame);
            }
        });
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1 = p1.getText().toString();
                Bundle players = new Bundle();
                players.putString("p1", player1);
                players.putString("mode", "1st");
                Intent startGame = new Intent(MainActivity.this,SinglePlayer.class);
                startGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startGame.putExtras(players);
                startActivity(startGame);
            }
        });
    }
}