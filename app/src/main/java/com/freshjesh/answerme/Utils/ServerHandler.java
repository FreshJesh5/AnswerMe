package com.freshjesh.answerme.Utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.freshjesh.answerme.Fragments.GameFragment;
import com.freshjesh.answerme.Fragments.PlayerlistFragment;
import com.freshjesh.answerme.Model.Game;
import com.freshjesh.answerme.Model.PlayerInfo;
import com.freshjesh.answerme.Threads.ServerConnectionThread;
import com.freshjesh.answerme.Threads.ServerSenderThread;

import java.net.Socket;
import java.util.Iterator;

/**
 * Created by joshc on 7/24/2017.
 */

public class ServerHandler extends Handler {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Bundle messageData = msg.getData();
        Object gameObject = messageData.getSerializable(Constants.DATA_KEY);

        if (gameObject instanceof PlayerInfo) {
            PlayerInfo playerInfo = (PlayerInfo) gameObject;
            PlayerlistFragment.deviceList.add(playerInfo.username);
            PlayerlistFragment.mAdapter.notifyItemInserted(PlayerlistFragment.deviceList.size() - 1);
        }
        if (gameObject instanceof Game) {
            if (GameFragment.gameObject != null) {
                GameFragment.gameObject = (Game) gameObject;
//                GameFragment.updatePlayerStatus();
                sendToAll(gameObject);
            } else {
                PlayerlistFragment.gameObject = (Game) gameObject;
            }
        }


    }

    public static void sendToAll(Object gameObject) {
        Iterator<Socket> socketIterator = ServerConnectionThread.socketUserMap.keySet().iterator();
        Socket socket;
        while (socketIterator.hasNext()) {
            socket = socketIterator.next();
            if (!ServerConnectionThread.socketUserMap.get(socket).equals(((Game) gameObject).senderUsername)) {
                ServerSenderThread sendGameName = new ServerSenderThread(socket, gameObject);
                sendGameName.start();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}