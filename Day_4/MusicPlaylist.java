package Day_4;

import java.util.Scanner;

class CircularPlaylist {
    private String[] songs;
    private int size, capacity;
    private int rear;
    private int current; // pointer for playing songs

    public CircularPlaylist(int capacity) {
        this.capacity = capacity;
        songs = new String[capacity];
        size = 0;
        rear = -1;
        current = 0;
    }

}

public class MusicPlaylist {
    public static void main(String[] args) {
    }
}
