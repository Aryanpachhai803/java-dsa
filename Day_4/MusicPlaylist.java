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

    public void addSong(String song) {
        if (size == capacity) {
            System.out.println("Playlist is full!");
            return;
        }

        rear = (rear + 1) % capacity;
        songs[rear] = song;
        size++;

        System.out.println("Added: " + song);
    }

    public void playNext() {
        if (size == 0) {
            System.out.println("Playlist is empty!");
            return;
        }

        System.out.println("Now Playing: " + songs[current]);
        current = (current + 1) % size; // loop only within valid songs
    }

    public void display() {
        if (size == 0) {
            System.out.println("Playlist is empty!");
            return;
        }

        System.out.println("\nPlaylist:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + songs[i]);
        }
    }
}

public class MusicPlaylist {
    public static void main(String[] args) {
    }
}
