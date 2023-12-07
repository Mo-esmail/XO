package com.xo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


public class Main extends Application {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnp;
    Label txtResult ;
    ArrayList<Boolean> Xplays=new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false,false,false,false));;
    ArrayList<Boolean> Yplays=new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false,false,false,false));
    boolean isPlayer1=true;
    boolean gameOver =false;

    @Override
    public void start(Stage primaryStage){
        //initialize all the buttons and set the text shown in them
        btn1=new Button("");
        btn2=new Button("");
        btn3=new Button("");
        btn4=new Button("");
        btn5=new Button("");
        btn6=new Button("");
        btn7=new Button("");
        btn8=new Button("");
        btn9=new Button("");
        btnp=new Button("play");
        //initialize the TextField
        txtResult=new Label("X's turn");
        //set the min sizes for all the components of the gui
        txtResult.setMinSize(100,20);
        btn1.setMinSize(70,25);
        btn2.setMinSize(70,25);
        btn3.setMinSize(70,25);
        btn4.setMinSize(70,25);
        btn5.setMinSize(70,25);
        btn6.setMinSize(70,25);
        btn7.setMinSize(70,25);
        btn8.setMinSize(70,25);
        btn9.setMinSize(70,25);
        HBox row1=new HBox(btn7,btn8,btn9);
        //set the spacing among the buttons in the row
        row1.setSpacing(5);
        //all btn4, btn5, btn6 and btnMinas to the same row
        HBox row2=new HBox(btn4,btn5,btn6);
        //set the spacing among the buttons in the row
        row2.setSpacing(5);
        //all btn1, btn2, btn3 and btnX to the same row
        HBox row3=new HBox(btn1,btn2,btn3);
        //set the spacing among the buttons in the row
        row3.setSpacing(5);
        //all btnC, btn0, btnEqual and btnDivision to the same row
        HBox row4=new HBox(btnp);
        //set the spacing among the buttons in the row
        row4.setSpacing(5);
        //add the text field and all the row to the application
        VBox root = new VBox(txtResult,row1,row2,row3,row4);
        //set the spacing among the rows in the application
        root.setSpacing(5);
        //set the padding around the vbox
        root.setPadding(new Insets(15));
        //set the title of the application
        primaryStage.setTitle("X O");
        //set up the Stage and set it's size then show it
        primaryStage.setScene(new Scene(root, 325, 225));
        primaryStage.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(0,btn1);
            }
        });

        //action listener for btn2 to handle it's click by the user
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(1,btn2);
            }
        });

        //action listener for btn3 to handle it's click by the user
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(2,btn3);
            }
        });

        //action listener for btn4 to handle it's click by the user
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(3,btn4);
            }
        });

        //action listener for btn5 to handle it's click by the user
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(4,btn5);
            }
        });

        //action listener for btn6 to handle it's click by the user
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(5,btn6);
            }
        });

        //action listener for btn7 to handle it's click by the user
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(6,btn7);
            }
        });

        //action listener for btn8 to handle it's click by the user
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(7,btn8);
            }
        });

        //action listener for btn9 to handle it's click by the user
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call worker method and pass the value of the button the user entered
                worker(8,btn9);
            }
        });

        btnp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Xplays=new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false,false,false,false));
                Yplays=new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false,false,false,false));
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                gameOver =false;
                isPlayer1=true;
                txtResult.setText("X's turn");
            }
        });

    }

    public void worker(int n,Button current){
        if(!gameOver){
            if(!Xplays.get(n)&&!Yplays.get(n)){
                if(isPlayer1){
                    isPlayer1=false;
                    current.setText("X");
                    Xplays.set(n,true);
                    txtResult.setText("O's turn");
                }else{
                    isPlayer1=true;
                    current.setText("O");
                    Yplays.set(n,true);
                    txtResult.setText("X's turn");
                }
                checkwin();
            }
        }
    }
    public void checkwin(){
        if (Xplays.get(0)&&Xplays.get(1)&&Xplays.get(2)||
                Xplays.get(3)&&Xplays.get(4)&&Xplays.get(5)||
                Xplays.get(6)&&Xplays.get(7)&&Xplays.get(8)||
                Xplays.get(0)&&Xplays.get(3)&&Xplays.get(6)||
                Xplays.get(1)&&Xplays.get(4)&&Xplays.get(7)||
                Xplays.get(2)&&Xplays.get(5)&&Xplays.get(8)||
                Xplays.get(0)&&Xplays.get(4)&&Xplays.get(8)||
                Xplays.get(2)&&Xplays.get(4)&&Xplays.get(6)){
            txtResult.setText("X won");
            gameOver =true;
        }else if (Yplays.get(0)&&Yplays.get(1)&&Yplays.get(2)||
                Yplays.get(3)&&Yplays.get(4)&&Yplays.get(5)||
                Yplays.get(6)&&Yplays.get(7)&&Yplays.get(8)||
                Yplays.get(0)&&Yplays.get(3)&&Yplays.get(6)||
                Yplays.get(1)&&Yplays.get(4)&&Yplays.get(7)||
                Yplays.get(2)&&Yplays.get(5)&&Yplays.get(8)||
                Yplays.get(0)&&Yplays.get(4)&&Yplays.get(8)||
                Yplays.get(2)&&Yplays.get(4)&&Yplays.get(6)){
            txtResult.setText("Y won");
            gameOver =true;
        }else if ((Xplays.get(0)||Yplays.get(0))&&
                (Xplays.get(1)||Yplays.get(1))&&
                (Xplays.get(2)||Yplays.get(2))&&
                (Xplays.get(3)||Yplays.get(3))&&
                (Xplays.get(4)||Yplays.get(4))&&
                (Xplays.get(5)||Yplays.get(5))&&
                (Xplays.get(6)||Yplays.get(6))&&
                (Xplays.get(7)||Yplays.get(7))&&
                (Xplays.get(8)||Yplays.get(8))){
            txtResult.setText("Draw");
            gameOver =true;
        }

    }

}
