package com.aniketchatterjee.tictactoe;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class SinglePlayer extends AppCompatActivity {
    int[][] game = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    TextView[][] pos;
    String player1;
    String player2;
    int count = 0;
    int mode;
    TextView turn;
    TextView SingleCell1;
    TextView SingleCell2;
    TextView SingleCell3;
    TextView SingleCell4;
    TextView SingleCell5;
    TextView SingleCell6;
    TextView SingleCell7;
    TextView SingleCell8;
    TextView SingleCell9;
    boolean status = true;
    Handler handler = new Handler();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        SingleCell1 = findViewById(R.id.cell_1);
        SingleCell2 = findViewById(R.id.cell_2);
        SingleCell3 = findViewById(R.id.cell_3);
        SingleCell4 = findViewById(R.id.cell_4);
        SingleCell5 = findViewById(R.id.cell_5);
        SingleCell6 = findViewById(R.id.cell_6);
        SingleCell7 = findViewById(R.id.cell_7);
        SingleCell8 = findViewById(R.id.cell_8);
        SingleCell9 = findViewById(R.id.cell_9);
        turn = findViewById(R.id.turn);
        player1 = getIntent().getStringExtra("p1");
        player2 = "System";
        mode = Objects.requireNonNull(getIntent().getStringExtra("mode")).equals("1st") ? 0 : 1;
        if (mode == 0) {
            turn.setText(("It's " + player1 + "'s turn"));
        } else {
            turn.setText(("It's " + player2 + "'s turn"));
        }

        pos = new TextView[][]{{SingleCell1, SingleCell2, SingleCell3}, {SingleCell4, SingleCell5, SingleCell6}, {SingleCell7, SingleCell8, SingleCell9}};
        if (mode == 1) {
            autoplay(2);
        }
        SingleCell1.setOnClickListener(view -> {
            if (game[0][0] == 0) {
                game[0][0] = 1;
                SingleCell1.setText("X");
                Log.d(TAG, "Cell 1 processed sucessfully");
                next();


            }
        });
        SingleCell2.setOnClickListener(view -> {
            if (game[0][1] == 0) {
                game[0][1] = 1;
                SingleCell2.setText("X");
                Log.d(TAG, "Cell 2 processed sucessfully");
                next();

            }
        });
        SingleCell3.setOnClickListener(view -> {
            if (game[0][2] == 0) {
                game[0][2] = 1;
                SingleCell3.setText("X");
                Log.d(TAG, "Cell 3 processed sucessfully");
                next();

            }
        });
        SingleCell4.setOnClickListener(view -> {
            if (game[1][0] == 0) {
                game[1][0] = 1;
                SingleCell4.setText("X");
                Log.d(TAG, "Cell 4 processed sucessfully");
                next();

            }
        });
        SingleCell5.setOnClickListener(view -> {
            if (game[1][1] == 0) {
                game[1][1] = 1;
                SingleCell5.setText("X");
                Log.d(TAG, "Cell 5 processed sucessfully");
                next();

            }
        });
        SingleCell6.setOnClickListener(view -> {
            if (game[1][2] == 0) {
                game[1][2] = 1;
                SingleCell6.setText("X");
                Log.d(TAG, "Cell 6 processed sucessfully");
                next();

            }
        });
        SingleCell7.setOnClickListener(view -> {
            if (game[2][0] == 0) {
                game[2][0] = 1;
                SingleCell7.setText("X");
                Log.d(TAG, "Cell 7 processed sucessfully");
                next();

            }

        });
        SingleCell8.setOnClickListener(view -> {
            if (game[2][1] == 0) {
                game[2][1] = 1;
                SingleCell8.setText("X");
                Log.d(TAG, "Cell 8 processed sucessfully");
                next();

            }
        });
        SingleCell9.setOnClickListener(view -> {
            if (game[2][2] == 0) {
                game[2][2] = 1;
                SingleCell9.setText("X");
                Log.d(TAG, "Cell 9 processed sucessfully");
                next();

            }
        });
    }

    private boolean winner() {
        if (((game[0][0] != 0) && (game[0][0] == game[0][1]) && (game[0][0] == game[0][2])) ||
                ((game[1][0] != 0) && (game[1][0] == game[1][1]) && (game[1][0] == game[1][2])) ||
                ((game[2][0] != 0) && (game[2][0] == game[2][1]) && (game[2][0] == game[2][2])) ||
                ((game[0][0] != 0) && (game[0][0] == game[1][0]) && (game[0][0] == game[2][0])) ||
                ((game[0][1] != 0) && (game[0][1] == game[1][1]) && (game[0][1] == game[2][1])) ||
                ((game[0][2] != 0) && (game[0][2] == game[1][2]) && (game[0][2] == game[2][2])) ||
                ((game[0][0] != 0) && (game[0][0] == game[1][1]) && (game[0][0] == game[2][2])) ||
                ((game[0][2] != 0) && (game[0][2] == game[1][1]) && (game[0][2] == game[2][0]))) {
            if ((count - mode) % 2 != 0) {
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
            return false;
        } else if (count > 8) {
            handler.postDelayed(() -> {
                openScreen("draw");
                resetGameState();
            }, 1000);
            return false;
        } else {
            return true;
        }
    }

    @SuppressLint("SetTextI18n")
    public void turn() {
        if ((count - mode) % 2 != 0) {
            turn.setText(("It's " + player2 + "'s turn"));
        } else {
            turn.setText(("It's " + player1 + "'s turn"));
        }
    }

    public void next() {
        count++;
        if (count > 4) {
            status = winner();
        }
        if (status) {
            turn();
            autoplay(2);
        }
    }


    public void openScreen(String extra) {
        Intent intent = new Intent(SinglePlayer.this, Winner.class);
        Bundle data = new Bundle();
        data.putString("p1", player1);
        data.putString("p2", player2);
        data.putString("result", extra);
        intent.putExtras(data);
        startActivity(intent);
    }

    public void autoplay(int i) {
        if ((game[0][0] == 0) && (game[0][1] == i) && (game[0][2] == i)) {
            SingleCell1.setText("O");
            game[0][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 1 processed sucessfully");
        } else if ((game[0][0] == i) && (game[0][1] == 0) && (game[0][2] == i)) {
            SingleCell2.setText("O");
            game[0][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 2 processed sucessfully");
        } else if ((game[0][0] == i) && (game[0][1] == i) && (game[0][2] == 0)) {
            SingleCell3.setText("O");
            game[0][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 3 processed sucessfully");
        } else if ((game[1][0] == 0) && (game[1][1] == i) && (game[1][2] == i)) {
            SingleCell4.setText("O");
            game[1][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 4 processed sucessfully");
        } else if ((game[1][0] == i) && (game[1][1] == 0) && (game[1][2] == i)) {
            SingleCell5.setText("O");
            game[1][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 5 processed sucessfully");
        } else if ((game[1][0] == i) && (game[1][1] == i) && (game[1][2] == 0)) {
            SingleCell6.setText("O");
            game[1][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 6 processed sucessfully");
        } else if ((game[2][0] == 0) && (game[2][1] == i) && (game[2][2] == i)) {
            SingleCell7.setText("O");
            game[2][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 7 processed sucessfully");
        } else if ((game[2][0] == i) && (game[2][1] == 0) && (game[2][2] == i)) {
            SingleCell8.setText("O");
            game[2][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 8 processed sucessfully");
        } else if ((game[2][0] == i) && (game[2][1] == i) && (game[2][2] == 0)) {
            SingleCell9.setText("O");
            game[2][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 9 processed sucessfully");
        } else if ((game[0][0] == 0) && (game[1][0] == i) && (game[2][0] == i)) {
            SingleCell1.setText("O");
            game[0][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 10 processed sucessfully");
        } else if ((game[0][0] == i) && (game[1][0] == 0) && (game[2][0] == i)) {
            SingleCell4.setText("O");
            game[1][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 11 processed sucessfully");
        } else if ((game[0][0] == i) && (game[1][0] == i) && (game[2][0] == 0)) {
            SingleCell7.setText("O");
            game[2][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 12 processed sucessfully");
        } else if ((game[0][1] == 0) && (game[1][1] == i) && (game[2][1] == i)) {
            SingleCell2.setText("O");
            game[0][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 13 processed sucessfully");
        } else if ((game[0][1] == i) && (game[1][1] == 0) && (game[2][1] == i)) {
            SingleCell5.setText("O");
            game[1][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 14 processed sucessfully");
        } else if ((game[0][1] == i) && (game[1][1] == i) && (game[2][1] == 0)) {
            SingleCell8.setText("O");
            game[2][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 15 processed sucessfully");
        } else if ((game[0][2] == 0) && (game[1][2] == i) && (game[2][2] == i)) {
            SingleCell3.setText("O");
            game[0][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 16 processed sucessfully");
        } else if ((game[0][2] == i) && (game[1][2] == 0) && (game[2][2] == i)) {
            SingleCell6.setText("O");
            game[1][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 17 processed sucessfully");
        } else if ((game[0][2] == i) && (game[1][2] == i) && (game[2][2] == 0)) {
            SingleCell9.setText("O");
            game[2][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 18 processed sucessfully");
        } else if ((game[0][0] == 0) && (game[1][1] == i) && (game[2][2] == i)) {
            SingleCell1.setText("O");
            game[0][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 19 processed sucessfully");
        } else if ((game[0][0] == i) && (game[1][1] == 0) && (game[2][2] == i)) {
            SingleCell5.setText("O");
            game[1][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 20 processed sucessfully");
        } else if ((game[0][0] == i) && (game[1][1] == i) && (game[2][2] == 0)) {
            SingleCell9.setText("O");
            game[2][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 21 processed sucessfully");
        } else if ((game[0][2] == 0) && (game[1][1] == i) && (game[2][0] == i)) {
            SingleCell3.setText("O");
            game[0][2] = 2;
            autoNext();
            Log.d(TAG, "Condition 22 processed sucessfully");
        } else if ((game[0][2] == i) && (game[1][1] == 0) && (game[2][0] == i)) {
            SingleCell5.setText("O");
            game[1][1] = 2;
            autoNext();
            Log.d(TAG, "Condition 23 processed sucessfully");
        } else if ((game[0][2] == i) && (game[1][1] == i) && (game[2][0] == 0)) {
            SingleCell7.setText("O");
            game[2][0] = 2;
            autoNext();
            Log.d(TAG, "Condition 24 processed sucessfully");
        } else {
            if (i == 1) {
                randPos();
                autoNext();
                Log.d(TAG, "random move processed sucessfully");
            } else {
                autoplay(1);
                Log.d(TAG, "No winning move,Checking for player possibility");
            }
        }
    }

    public void randPos() {
        Random r = new Random();
        int max = 3;
        int x = r.nextInt(max);
        int y = r.nextInt(max);
        if (game[x][y] != 0) {
            randPos();
        }
        game[x][y] = 2;
        TextView position = pos[x][y];
        position.setText("O");
    }

    public void autoNext() {
        count++;
        if (count > 4) {
            winner();
        }
        turn();
    }
    public void resetGameState(){
        SingleCell1.setText("");
        SingleCell2.setText("");
        SingleCell3.setText("");
        SingleCell4.setText("");
        SingleCell5.setText("");
        SingleCell6.setText("");
        SingleCell7.setText("");
        SingleCell8.setText("");
        SingleCell9.setText("");
        turn.setText("");
        count=0;
        mode=0;
        game = null;
        pos = null;

    }
}
