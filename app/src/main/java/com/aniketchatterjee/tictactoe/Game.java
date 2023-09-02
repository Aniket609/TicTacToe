package com.aniketchatterjee.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    int[][] game = new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    String player1;
    String player2;
    int count=0;
    int mode;
    TextView turn;
    TextView cell1;
    TextView cell2;
    TextView cell3;
    TextView cell4;
    TextView cell5;
    TextView cell6;
    TextView cell7;
    TextView cell8;
    TextView cell9;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        cell1 = findViewById(R.id.cell_1);
        cell2 = findViewById(R.id.cell_2);
        cell3 = findViewById(R.id.cell_3);
        cell4 = findViewById(R.id.cell_4);
        cell5 = findViewById(R.id.cell_5);
        cell6 = findViewById(R.id.cell_6);
        cell7 = findViewById(R.id.cell_7);
        cell8 = findViewById(R.id.cell_8);
        cell9 = findViewById(R.id.cell_9);
        turn = findViewById(R.id.turn);
        player1 = getIntent().getStringExtra("p1");
        player2 = getIntent().getStringExtra("p2");
        String m = getIntent().getStringExtra("mode");
        assert m != null;
        mode = m.equals("1st")?0:1;
        if (player1.isEmpty()) player1 = "Player1";
        if (player2.isEmpty()) player2 = "Player2";
        turn();

        cell1.setOnClickListener(view -> {
            if (game[0][0]==0){
                boolean turn = playing();
                game [0][0] = turn?1:2;
                cell1.setText( turn?"X":"O");
               next();
            }
        });
        cell2.setOnClickListener(view -> {
            if (game[0][1]==0){
                boolean turn = playing();
                game [0][1] = turn?1:2;
                cell2.setText( turn?"X":"O");
                next();
            }
        });
        cell3.setOnClickListener(view -> {
            if (game[0][2]==0){
                boolean turn = playing();
                game [0][2] = turn?1:2;
                cell3.setText( turn?"X":"O");
                next();
            }
        });
        cell4.setOnClickListener(view -> {
            if (game[1][0]==0){
                boolean turn = playing();
                game [1][0] = turn?1:2;
                cell4.setText( turn?"X":"O");
                next();
            }
        });
        cell5.setOnClickListener(view -> {
            if (game[1][1]==0){
                boolean turn = playing();
                game [1][1] = turn?1:2;
                cell5.setText( turn?"X":"O");
                next();
            }
        });
        cell6.setOnClickListener(view -> {
            if (game[1][2]==0){
                boolean turn = playing();
                game [1][2] = turn?1:2;
                cell6.setText( turn?"X":"O");
                next();
            }
        });
        cell7.setOnClickListener(view -> {
           if(game[2][0]==0){
               boolean turn = playing();
               game [2][0] = turn?1:2;
               cell7.setText( turn?"X":"O");
               next();
           }
        });
        cell8.setOnClickListener(view -> {
            if (game[2][1]==0){
                boolean turn = playing();
                game [2][1] = turn?1:2;
                cell8.setText( turn?"X":"O");
                next();
            }
        });
        cell9.setOnClickListener(view -> {
            if (game[2][2]==0){
                boolean turn = playing();
                game [2][2] = turn?1:2;
                cell9.setText( turn?"X":"O");
                next();
                cell9.setOnClickListener(null);
            }
        });

    }

    private void winner() {
        if  (((game[0][0] != 0) && (game[0][0] == game[0][1]) && (game[0][0] == game[0][2]))||
                ((game[1][0] != 0) && (game[1][0] == game[1][1]) && (game[1][0] == game[1][2])) ||
                ((game[2][0] != 0) && (game[2][0] == game[2][1]) && (game[2][0] == game[2][2])) ||
                ((game[0][0] != 0) && (game[0][0] == game[1][0]) && (game[0][0] == game[2][0])) ||
                ((game[0][1] != 0) && (game[0][1] == game[1][1]) && (game[0][1] == game[2][1])) ||
                ((game[0][2] != 0) && (game[0][2] == game[1][2]) && (game[0][2] == game[2][2])) ||
                ((game[0][0] != 0) && (game[0][0] == game[1][1]) && (game[0][0] == game[2][2])) ||
                ((game[0][2] != 0) && (game[0][2] == game[1][1]) && (game[0][2] == game[2][0]))){
            if ((count-mode) % 2 != 0) {
                handler.postDelayed(() -> {
                    openScreen("player1");
                    resetGameState();
                }, 1000);
            } else {
                handler.postDelayed(() -> {
                    openScreen("player2");
                    resetGameState();
                }, 1000);
            }
        }
        else if (count>8){
            handler.postDelayed(() -> {
                openScreen("draw");
                resetGameState();
            }, 1000);
        }

    }
    @SuppressLint("SetTextI18n")
    public void turn(){
        if ((count-mode)%2!=0){
            turn.setText(("It's "+ player2+"'s turn"));
        }
        else{
            turn.setText(("It's "+ player1+"'s turn"));
        }
    }


    public void openScreen (String extra){
        Intent intent = new Intent(Game.this, Winner.class);
        Bundle data = new Bundle();
        data.putString("p1", player1);
        data.putString("p2",player2);
        data.putString("result",extra);
        intent.putExtras(data);
        startActivity(intent);
    }
    public void next(){
        count++;
        if (count>4){
            winner();
        }
        turn();
    }
    public boolean playing(){
        return (count-mode)%2!=0;
    }
    public void resetGameState(){
        cell1.setText("");
        cell2.setText("");
        cell3.setText("");
        cell4.setText("");
        cell5.setText("");
        cell6.setText("");
        cell7.setText("");
        cell8.setText("");
        cell9.setText("");
        turn.setText("");
        count=0;
        mode=0;
        game = null;


    }
}
