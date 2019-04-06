package com.bipin.practice.media;

import java.io.File;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MyMusicPlayer extends Application {
	private static MediaPlayer mediaPlayer;

	void playMedia() {
		File f = new File("F:\\movies\\Killa2015.mp4");
		Media media = new Media(f.toURI().toString());

		mediaPlayer = new MediaPlayer(media);
		Thread t = new Thread() {
			public void run() {
				mediaPlayer.play();
				// mediaPlayer.p
				while (mediaPlayer.getTotalDuration()
						.equals(mediaPlayer.getCurrentTime())) {
					try {
						Thread.sleep(2000);
						System.out.println(mediaPlayer.getTotalDuration());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		};
		t.start();
	}

	public static void main(String args[]) {
		new MyMusicPlayer().playMedia();
	}

	@Override
	public void start(Stage stage) throws Exception {
	}
}