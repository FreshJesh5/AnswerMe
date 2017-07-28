package com.freshjesh.answerme.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by joshc on 7/24/2017.
 */

public class Game implements Serializable {
    private int numberOfPlayer;
    public ArrayList<Player> players;
    public String gameName;
    public String senderUsername;
    private boolean[] myGameGrid = new boolean[9];


    public Game(ArrayList<Player> players, String gameName) {
//        this.senderUsername = null;
        this.players = players;
        this.numberOfPlayer = players.size();
        this.gameName = gameName;
        if (players.size() > 6) {
//            usernames.remove(usernames.size() - 1);
            throw new IllegalArgumentException("Number of players above the allowed limit (6)");
        }

//        for (int i = 0; i < numberOfPlayer; i++) {
//            players.add(new Player(i + 1, players.get(i), true));
//        }
//        usernames.remove(usernames.size() - 1);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void buttonClicked (int i ) {
        myGameGrid[i] = !myGameGrid[i];
        Log.d("Game", "buttonClicked");
    }

    public boolean[] getGrid() {return myGameGrid;}

}
