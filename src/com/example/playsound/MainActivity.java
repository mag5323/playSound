package com.example.playsound;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends Activity {
	protected MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button play = (Button) findViewById(R.id.play);
		Button pause = (Button) findViewById(R.id.pause);
		SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);
		mp = MediaPlayer.create(this,R.raw.car);	
		
		play.setOnClickListener(new Button.OnClickListener(){             
			@Override
            public void onClick(View v) {
				if(mp==null){
					mp.stop();				
				}
				mp.start();
            }
        });
		
		pause.setOnClickListener(new Button.OnClickListener(){             
			@Override
            public void onClick(View v) {
				if(mp.isPlaying()){
					mp.pause();
				}
            }
		});     
		
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){  			  
			@Override  
			   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {  
				   float speed = new Float(progress/100.0);
				   mp.setVolume(speed,speed);
			   }

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
		});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
