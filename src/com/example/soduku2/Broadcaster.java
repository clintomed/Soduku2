package com.example.soduku2;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import com.vaadin.ui.GridLayout;

public class Broadcaster implements Serializable {
    private static final long serialVersionUID = -368230891317363146L;

	
    static ExecutorService executorService =
        Executors.newSingleThreadExecutor();

    public interface BroadcastListener {
        void receiveBroadcast(String message);
        void updateBoard(Board board);
    }
    
    private static LinkedList<BroadcastListener> listeners =
        new LinkedList<BroadcastListener>();
    
    public static synchronized void register(
            BroadcastListener listener) {
        listeners.add(listener);
    }
    
    public static synchronized void unregister(
            BroadcastListener listener) {
        listeners.remove(listener);
    }
    
    public static synchronized void broadcast(
            final String message) {
        for (final BroadcastListener listener: listeners)
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                	
                    listener.receiveBroadcast(message);
                   
                }
            });
    }
    
    public static synchronized void broadcastBoard(
            final Board board) {
        for (final BroadcastListener listener: listeners)
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                	
                   
                    listener.updateBoard(board);
                }
            });
    }
    
}