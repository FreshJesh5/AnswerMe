package com.freshjesh.answerme.Fragments;

import android.graphics.Color;
import android.os.Bundle;
<<<<<<< HEAD:app/src/main/java/com/freshjesh/answerme/Fragments/GameFragment.java
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
=======
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
>>>>>>> parent of a146ee2... working app, start working on new game:app/src/main/java/com/freshjesh/answerme/Activities/GameActivity.java
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.freshjesh.answerme.Model.Game;
import com.freshjesh.answerme.R;
import com.freshjesh.answerme.Threads.ClientConnectionThread;
import com.freshjesh.answerme.Utils.ClientHandler;
import com.freshjesh.answerme.Utils.Constants;
import com.freshjesh.answerme.Utils.ServerHandler;
import com.freshjesh.answerme.Utils.SocketHandler;

import java.net.Socket;

import java.net.Socket;

/**
 * Created by joshc on 7/25/2017.
 */

public class GameFragment extends Fragment {

    public static View rootView;
    public static Game gameObject;
    public static Socket socket;
    public static Button[] myLayoutGrid = new Button[9];
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    int i;
=======
>>>>>>> parent of a146ee2... working app, start working on new game
=======
    int i;
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
    int i;
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
    int i;
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity

    public GameFragment() {

<<<<<<< HEAD:app/src/main/java/com/freshjesh/answerme/Fragments/GameFragment.java
    }
=======
    private static Game gameObject;
    private Socket socket;
    private static Button[] myLayoutGrid = new Button[9];
>>>>>>> parent of a146ee2... working app, start working on new game:app/src/main/java/com/freshjesh/answerme/Activities/GameActivity.java

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/com/freshjesh/answerme/Fragments/GameFragment.java
    }
=======
        setContentView(R.layout.main_game_layout);

        Intent intent = getIntent();
        gameObject = (Game)intent.getSerializableExtra(Constants.MESSAGE_KEY);
        socket = SocketHandler.getSocket();

>>>>>>> parent of a146ee2... working app, start working on new game:app/src/main/java/com/freshjesh/answerme/Activities/GameActivity.java

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_game_layout, container, false);

        int[] ids={R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.btn7, R.id.btn8, R.id.btn9};

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        for (i = 0 ; i < myLayoutGrid.length ; i++)
=======
        for (int i = 0 ; i < myLayoutGrid.length ; i++)
>>>>>>> parent of a146ee2... working app, start working on new game
=======
        for (i = 0 ; i < myLayoutGrid.length ; i++)
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
        for (i = 0 ; i < myLayoutGrid.length ; i++)
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
        for (i = 0 ; i < myLayoutGrid.length ; i++)
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
        {
            myLayoutGrid[i] = (Button) rootView.findViewById(ids[i]);
            myLayoutGrid[i].setBackgroundColor(Color.BLUE);
            myLayoutGrid[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentIndex = 0;
                    switch (view.getId()){
                        case R.id.btn1: currentIndex = 0; break;
                        case R.id.btn2: currentIndex = 1; break;
                        case R.id.btn3: currentIndex = 2; break;
                        case R.id.btn4: currentIndex = 3; break;
                        case R.id.btn5: currentIndex = 4; break;
                        case R.id.btn6: currentIndex = 5; break;
                        case R.id.btn7: currentIndex = 6; break;
                        case R.id.btn8: currentIndex = 7; break;
                        case R.id.btn9: currentIndex = 8; break;
                    }
                    gameObject.buttonClicked(currentIndex);
                    updateButton(gameObject.getGrid()[currentIndex], myLayoutGrid[currentIndex]);
                    updateGameForAll();
                }
            });
        }

        return rootView;
    }

    public void setParameters(Game gameObject, Socket socket) {
        this.gameObject = gameObject;
        this.socket = socket;
    }

    public static void updateButton(boolean bool, Button button) {
        if(bool){
            button.setBackgroundColor(Color.RED);
        }
        else {button.setBackgroundColor(Color.BLUE);}
        Log.d("GameFragment", "updateButton");
    }

    public static void updateGrid (){
        for (int i = 0 ; i < gameObject.getGrid().length ; i++) {
            if(gameObject.getGrid()[i]){
                myLayoutGrid[i].setBackgroundColor(Color.RED);
            }
            else {myLayoutGrid[i].setBackgroundColor(Color.BLUE);}
        }
        Log.d("GameFragment", "updateGrid");
    }

    public static void updateGameForAll() {
        if (ClientConnectionThread.serverStarted) {
            ClientHandler.sendToServer(gameObject);
        } else {
            if (Constants.isPlayerActive(MainFragment.userName.getText().toString(), gameObject)) {
                ServerHandler.sendToAll(gameObject);
            }
        }
        Log.d("GameFragment", "updateGameForAll");
    }
}
