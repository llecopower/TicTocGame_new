package com.example.tictocgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int grid_size;
    TableLayout gameboard;
    TextView txt_turn;
    char [][] my_board;
    char turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid_size = Integer.parseInt("3");
        my_board = new char[grid_size][grid_size];

        gameboard = (TableLayout) findViewById(R.id.mainBoard);
        txt_turn =  (TextView)  findViewById(R.id.turn);

         resetBoard();

        txt_turn.setText("Turn: " + turn);

        for (int i=0; i < gameboard.getChildCount(); i++){

            TableRow row = (TableRow)  gameboard.getChildAt(i);
                for (int j=0; j<row.getVirtualChildCount();j++){
                TextView tv = (TextView) row.getVirtualChildAt(j);
                tv.setText(" ");
                 tv.setOnClickListener(Move(i,j,tv));
             }
        }


        Button reset_btn = (Button) findViewById(R.id.reset);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent current = getIntent();
                finish();
                startActivity(current);
            }
        });
    }


    protected void resetBoard(){
        turn = 'X';
        for(int i = 0; i< grid_size; i++){
            for(int j = 0; j< grid_size; j++){
                my_board[i][j] = ' ';
            }
        }
    }


    protected int gameStatus(){

    //0 Continue
    //1 X Wins
    //2 O Wins
    //-1 Draw


    int rowX = 0, colX = 0, rowO=0, col=0;

    if (check_Row_Equality(i, X))






    }


    protected boolean check_Row_Equality(int r, char player){
        int count_Equal=0;
        for(int i = 0; i< grid_size; i++){
            if(my_board[r][i]==player)
                count_Equal++;
        }

        if(count_Equal== grid_size)
            return true;
        else
            return false;
    }


    protected boolean check_Column_Equality(int c, char player){
        int count_Equal=0;
        for(int i = 0; i< grid_size; i++){
            if(my_board[i][c]==player)
                count_Equal++;
        }

        if(count_Equal== grid_size)
            return true;
        else
            return false;
    }

        protected boolean Cell_Set(int r, int c) {

            return !(my_board[r][c]==' ');
            //if what I have inside of my cells is igual to empty ' '
            //the cell have no value

        }




    View.OnClickListener Move(final int r, final int c, final TextView tv) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Cell_Set(r,c)){
                    my_board[r][c] = turn;
                    if (turn == 'X'){
                        tv.setText(R.string.X);
                        turn = 'O';
                    } else if (turn == 'O'){
                        tv.setText(R.string.O);
                        turn = 'X';
                    }

                    if (gameStatus() == 0) {
                        tv.setText("Turn: Player " + turn);
                    }
                    else if (gameStatus() == -1) {
                        tv.setText("This is a Draw Match");
                        stopMach();
                    }
                    else {
                    txt_turn.setText(turn + "Loses!");
                        stopMach();
                    }
                } else {
                    txt_turn.setText(txt_turn.getText() + " Choose an Empty Call");

                }
            }
        };
    };















}