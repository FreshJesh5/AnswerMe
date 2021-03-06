package com.freshjesh.answerme.Threads;

import android.os.Bundle;
import android.os.Message;

import com.freshjesh.answerme.Fragments.HostFragment;
import com.freshjesh.answerme.Model.Game;
import com.freshjesh.answerme.Model.Player;
import com.freshjesh.answerme.Utils.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by joshc on 7/25/2017.
 */

public class ServerListenerThread extends Thread {

    private Socket hostThreadSocket;

    ServerListenerThread(Socket soc) {
        hostThreadSocket = soc;
    }

    @Override
    public void run() {
        while (true) {
            ObjectInputStream objectInputStream;
            try {
                InputStream inputStream = null;
                inputStream = hostThreadSocket.getInputStream();
                objectInputStream = new ObjectInputStream(inputStream);
                Object gameObject;
                Bundle data = new Bundle();
                gameObject = objectInputStream.readObject();
                if (gameObject != null) {
<<<<<<< HEAD
                    if (gameObject instanceof Player) {
                        data.putSerializable(Constants.DATA_KEY, (Player) gameObject);
//                        data.putInt(Constants.ACTION_KEY, Constants.PLAYER_LIST_UPDATE);
                        SocketHandler.setSocketMap(hostThreadSocket, ((Player) gameObject).username);
=======
                    if (gameObject instanceof PlayerInfo) {
                        data.putSerializable(Constants.DATA_KEY, (PlayerInfo) gameObject);
                        data.putInt(Constants.ACTION_KEY, Constants.PLAYER_LIST_UPDATE);
                        ServerConnectionThread.socketUserMap.put(hostThreadSocket, ((PlayerInfo) gameObject).username);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
=======
>>>>>>> parent of 88bcace... working app, 2nd version with Game Activity
                    } else {
                        data.putSerializable(Constants.DATA_KEY, (Game) gameObject);
                    }
                    Message msg = new Message();
                    msg.setData(data);
                    HostFragment.serverHandler.sendMessage(msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
