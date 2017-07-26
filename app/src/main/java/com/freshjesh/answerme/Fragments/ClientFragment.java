package com.freshjesh.answerme.Fragments;

/**
 * Created by joshc on 7/24/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.freshjesh.answerme.Model.Game;
import com.freshjesh.answerme.R;
import com.freshjesh.answerme.Threads.ClientConnectionThread;

public class ClientFragment extends Fragment {
    public static TextView gameName;
    public static TextView userName;
    public static Game gameobject;

    public ClientFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.client_join_game, container, false);
        Button joinGame = (Button) rootView.findViewById(R.id.joinGame);
        gameName = (TextView) rootView.findViewById(R.id.gameName);
        userName = (TextView) rootView.findViewById(R.id.userName);
        userName.setText(MainFragment.userName.getText());
        ClientConnectionThread clientConnect = new ClientConnectionThread(MainFragment.userName.getText().toString());
        clientConnect.start();
        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        joinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameobject != null) {
                    GameFragment gameFragment = new GameFragment();
                    gameFragment.setParameters(gameobject, ClientConnectionThread.socket);
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, gameFragment).addToBackStack(GameFragment.class.getName())
                            .commit();
                } else {
                    Toast.makeText(getActivity(), "Game setup not complete. Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }
}
