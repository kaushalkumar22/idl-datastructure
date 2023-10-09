package com.structural;

public class AdapterPatternClient {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaAdapter();
        mediaPlayer.play("mp3");
        mediaPlayer.play("wav");
        mediaPlayer.play("avi");
    }
}
// Target Interface
interface MediaPlayer {
    void play(String mediaType);
}
// Adaptee
class LegacyPlayer {
    void playWav() {
        System.out.println("Playing WAV file");
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    private LegacyPlayer legacyPlayer;
    MediaAdapter() {
        this.legacyPlayer = new LegacyPlayer();
    }
    @Override
    public void play(String mediaType) {
        if (mediaType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: ");
        } else if (mediaType.equalsIgnoreCase("wav")) {
            legacyPlayer.playWav();
        } else {
            System.out.println("Unsupported media type: " + mediaType);
        }
    }
}
