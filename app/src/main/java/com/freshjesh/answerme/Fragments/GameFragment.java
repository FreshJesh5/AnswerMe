package com.freshjesh.answerme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freshjesh.answerme.Model.Game;
import com.freshjesh.answerme.R;

import java.net.Socket;

/**
 * Created by joshc on 7/25/2017.
 */

public class GameFragment extends Fragment {

    public static View rootView;
    public static Game gameObject;
    public static Socket socket;

    public GameFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_game_layout, container, false);
        return rootView;
    }

    public void setParameters(Game gameObject, Socket socket) {
        this.gameObject = gameObject;
        this.socket = socket;
    }

}
