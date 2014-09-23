package com.algonquincollege.wieg0002.rgbatool;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity {

	NumberPicker _pickerRed;
	NumberPicker _pickerGreen;
	NumberPicker _pickerBlue;
	SeekBar _seekAlpha;

	TextView _textViewCurrentColour;
	EditText _editTextColourText;
	int _rgbRed;
	int _rgbGreen;
	int _rgbBlue;
	float _alpha;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    	_rgbRed = 255;
    	_rgbGreen = 187;
    	_rgbBlue = 85;
    	_alpha = 1;

        _pickerRed =  (NumberPicker) findViewById(R.id.pickerRed);
        _pickerRed.setMaxValue(255);
        _pickerRed.setMinValue(0);
        _pickerRed.setValue(255);
        _pickerRed.setWrapSelectorWheel(true); 
        _pickerRed.setOnValueChangedListener( new OnValueChangeListener()
        {
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal)
			{
				_rgbRed = newVal;
				changeColour();
			}
        });
        
        _pickerGreen =  (NumberPicker) findViewById(R.id.pickerGreen);
        _pickerGreen.setMaxValue(255);
        _pickerGreen.setMinValue(0);
        _pickerGreen.setValue(187);
        _pickerGreen.setWrapSelectorWheel(true); 
        _pickerGreen.setOnValueChangedListener( new OnValueChangeListener()
        {
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal)
			{
				_rgbGreen = newVal;
				changeColour();
			}
        });

        _pickerBlue =  (NumberPicker) findViewById(R.id.pickerBlue);
        _pickerBlue.setMaxValue(255);
        _pickerBlue.setMinValue(0);
        _pickerBlue.setValue(85);
        _pickerBlue.setWrapSelectorWheel(true);
        _pickerBlue.setOnValueChangedListener( new OnValueChangeListener()
        {
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal)
			{
				_rgbBlue = newVal;
				changeColour();
			}
        });
        
        _seekAlpha = (SeekBar) findViewById(R.id.seekBarAlpha);
        _seekAlpha.setProgress(100);
        _seekAlpha.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				_alpha = (float)progress/100;
				changeColour();
			}
		});
        
        _textViewCurrentColour = (TextView) findViewById(R.id.textViewCurrentColour);
        _editTextColourText = (EditText) findViewById(R.id.editTextCurrentColour);

        changeColour();

    }

    public void changeColour()
    {
		_textViewCurrentColour.setBackgroundColor(Color.rgb(_rgbRed, _rgbGreen, _rgbBlue));
		_textViewCurrentColour.setTextColor(Color.rgb(255-_rgbRed, 255-_rgbGreen, 255-_rgbBlue));
		String hex = "Alpha: " + _alpha + " Hex: ";//getResources().getString(R.string.current_colour);
		HexBuilder hb = new HexBuilder(_rgbRed, _rgbGreen, _rgbBlue);
		hex += hb.getHex();
		//_textViewCurrentColour.setText(hex);
		_textViewCurrentColour.setAlpha(_alpha);
		_editTextColourText.setText(hex);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
