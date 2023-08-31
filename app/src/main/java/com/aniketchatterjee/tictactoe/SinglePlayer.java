package com.aniketchatterjee.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SinglePlayer extends AppCompatActivity {
    int[][] game = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    TextView[][] pos;
    String player1;
    String player2;
    int count = 0;
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
    boolean status = true;


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
        player2 = "System";
        mode = getIntent().getStringExtra("mode").equals("1st") ? 0 : 1;
        if (mode == 0) {
            turn.setText(("It's " + player1 + "'s turn"));
        } else {
            turn.setText(("It's " + player2 + "'s turn"));
        }

        pos = new TextView[][]{{cell1, cell2, cell3}, {cell4, cell5, cell6}, {cell7, cell8, cell9}};
        if (mode == 1) {
            autoplay(2);
        }
        cell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[0][0] == 0) {
                    game[0][0] = 1;
                    cell1.setText("X");
                    next();
                }
            }
        });
        cell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[0][1] == 0) {
                    game[0][1] = 1;
                    cell2.setText("X");
                    next();
                }
            }
        });
        cell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[0][2] == 0) {
                    game[0][2] = 1;
                    cell3.setText("X");
                    next();
                }
            }
        });
        cell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[1][0] == 0) {
                    game[1][0] = 1;
                    cell4.setText("X");
                    next();
                }
            }
        });
        cell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[1][1] == 0) {
                    game[1][1] = 1;
                    cell5.setText("X");
                    next();
                }
            }
        });
        cell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[1][2] == 0) {
                    game[1][2] = 1;
                    cell6.setText("X");
                    next();
                }
            }
        });
        cell7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[2][0] == 0) {
                    game[2][0] = 1;
                    cell7.setText("X");
                    next();
                }

            }
        });
        cell8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[2][1] == 0) {
                    game[2][1] = 1;
                    cell8.setText("X");
                    next();
                }
            }
        });
        cell9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game[2][2] == 0) {
                    game[2][2] = 1;
                    cell9.setText("X");
                    next();
                }
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
                openScreen("player1");
            } else {
                openScreen("player2");
            }
            return false;
        } else if (count > 8) {
            openScreen("draw");
            return false;
        } else {
            return true;
        }
    }

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
            cell1.setText("O");
            game[0][0] = 2;
            autoNext();
        } else if ((game[0][0] == i) && (game[0][1] == 0) && (game[0][2] == i)) {
            cell2.setText("O");
            game[0][1] = 2;
            autoNext();
        } else if ((game[0][0] == i) && (game[0][1] == i) && (game[0][2] == 0)) {
            cell3.setText("O");
            game[0][2] = 2;
            autoNext();
        } else if ((game[1][0] == 0) && (game[1][1] == i) && (game[1][2] == i)) {
            cell4.setText("O");
            game[1][0] = 2;
            autoNext();
        } else if ((game[1][0] == i) && (game[1][1] == 0) && (game[1][2] == i)) {
            cell5.setText("O");
            game[1][1] = 2;
            autoNext();
        } else if ((game[1][0] == i) && (game[1][1] == i) && (game[1][2] == 0)) {
            cell6.setText("O");
            game[1][2] = 2;
            autoNext();
        } else if ((game[2][0] == 0) && (game[2][1] == i) && (game[2][2] == i)) {
            cell7.setText("O");
            game[2][0] = 2;
            autoNext();
        } else if ((game[2][0] == i) && (game[2][1] == 0) && (game[2][2] == i)) {
            cell8.setText("O");
            game[2][1] = 2;
            autoNext();
        } else if ((game[2][0] == i) && (game[2][1] == i) && (game[2][2] == 0)) {
            cell9.setText("O");
            game[2][2] = 2;
            autoNext();
        } else if ((game[0][0] == 0) && (game[1][0] == i) && (game[2][0] == i)) {
            cell1.setText("O");
            game[0][0] = 2;
            autoNext();
        } else if ((game[0][0] == i) && (game[1][0] == 0) && (game[2][0] == i)) {
            cell4.setText("O");
            game[1][0] = 2;
            autoNext();
        } else if ((game[0][0] == i) && (game[1][0] == i) && (game[2][0] == 0)) {
            cell7.setText("O");
            game[2][0] = 2;
            autoNext();
        } else if ((game[0][1] == 0) && (game[1][1] == i) && (game[2][1] == i)) {
            cell2.setText("O");
            game[0][1] = 2;
            autoNext();
        } else if ((game[0][1] == i) && (game[1][1] == 0) && (game[2][1] == i)) {
            cell5.setText("O");
            game[1][1] = 2;
            autoNext();
        } else if ((game[0][1] == i) && (game[1][1] == i) && (game[2][1] == 0)) {
            cell8.setText("O");
            game[2][1] = 2;
            autoNext();
        } else if ((game[0][2] == 0) && (game[1][2] == i) && (game[2][2] == i)) {
            cell3.setText("O");
            game[0][2] = 2;
            autoNext();
        } else if ((game[0][2] == i) && (game[1][2] == 0) && (game[2][2] == i)) {
            cell6.setText("O");
            game[1][2] = 2;
            autoNext();
        } else if ((game[0][2] == i) && (game[1][2] == i) && (game[2][2] == 0)) {
            cell9.setText("O");
            game[2][2] = 2;
            autoNext();
        } else if ((game[0][0] == 0) && (game[1][1] == i) && (game[2][2] == i)) {
            cell1.setText("O");
            game[0][0] = 2;
            autoNext();
        } else if ((game[0][0] == i) && (game[1][1] == 0) && (game[2][2] == i)) {
            cell5.setText("O");
            game[1][1] = 2;
            autoNext();
        } else if ((game[0][0] == i) && (game[1][1] == i) && (game[2][2] == 0)) {
            cell9.setText("O");
            game[2][2] = 2;
            autoNext();
        } else if ((game[0][2] == 0) && (game[1][1] == i) && (game[2][0] == i)) {
            cell3.setText("O");
            game[0][2] = 2;
            autoNext();
        } else if ((game[0][2] == i) && (game[1][1] == 0) && (game[2][0] == i)) {
            cell5.setText("O");
            game[1][1] = 2;
            autoNext();
        } else if ((game[0][2] == i) && (game[1][1] == i) && (game[2][0] == 0)) {
            cell7.setText("O");
            game[2][0] = 2;
            autoNext();
        } else {
            if (i == 1) {
                randPos();
                autoNext();
            } else {
                autoplay(1);
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
}
