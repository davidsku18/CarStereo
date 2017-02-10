package cs371.carstereo;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.SeekBar;


public class MainActivity extends Activity {

    int[] amPresets = {550, 600, 650, 700, 750, 800};
    double[] fmPresets = {90.9, 92.9, 94.9, 96.9, 98.9, 100.9};
    boolean powerOn;
    boolean fm = false;
    double base = 100;
    private double amR;
    private double fmR;
    ToggleButton power;
    SeekBar tuner;
    private TextView display;
    private Button preset1;
    private Button preset2;
    private Button preset3;
    private Button preset4;
    private Button preset5;
    private Button preset6;
    int AMMIN = 530;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerOn=true;

        display = (TextView)findViewById(R.id.display);
        power = (ToggleButton) findViewById(R.id.power);
        power.setOnClickListener(new powerButtonListener());


        seekBarListener tunerListener = new seekBarListener();
        tuner = (SeekBar)findViewById(R.id.tuner);
        tuner.setOnSeekBarChangeListener(new seekBarListener());


        preset1 = (Button) findViewById(R.id.preset1);
        preset2 = (Button) findViewById(R.id.preset2);
        preset3 = (Button) findViewById(R.id.preset3);
        preset4 = (Button) findViewById(R.id.preset4);
        preset5 = (Button) findViewById(R.id.preset5);
        preset6 = (Button) findViewById(R.id.preset6);
        presetListener PL = new presetListener();

        preset1.setOnClickListener(PL);
        preset2.setOnClickListener(PL);
        preset3.setOnClickListener(PL);
        preset4.setOnClickListener(PL);
        preset5.setOnClickListener(PL);

        longButtonListener LB = new longButtonListener();
        preset1.setOnLongClickListener(LB);
        preset2.setOnLongClickListener(LB);
        preset3.setOnLongClickListener(LB);
        preset4.setOnLongClickListener(LB);
        preset5.setOnLongClickListener(LB);

    }


    public class powerButtonListener implements View.OnClickListener {

        public void onClick(View v) {

            if(powerOn){
                display.setBackgroundColor(0xFFD3D3D3);
                //powerOn=false;
            }
            else {
                display.setBackgroundColor(0xFF000000);
                //powerOn=true;
            }

            powerOn = !powerOn;
        }
    }
    public void amListener(View v){
        if (fm)
        {
            tuner.setMax(198);
            tuner.setProgress(99);
            display.setText("98.0 FM");

        }
        else
        {
            tuner.setMax(1170);
            tuner.setProgress(585);
            display.setText("1115 AM");
        }
        fm=!fm;
    }

    private class longButtonListener implements  View.OnLongClickListener{

        @Override
        public boolean onLongClick(View view) {

            if(view.getId() == R.id.preset1)
            {
                if (!fm) {
                    fmPresets[0] = ((double)tuner.getProgress() + (double)881)/10;
                }
                else
                {
                    amPresets[0] = tuner.getProgress()+530;
                }
            }
            else if(view.getId() == R.id.preset2)
            {
                if (!fm) {
                    fmPresets[1] = ((double)tuner.getProgress() + (double)881)/10;
                }
                else
                {
                    amPresets[1] = tuner.getProgress()+530;
                }
            }
            else if(view.getId() == R.id.preset3)
            {
                if (!fm) {
                    fmPresets[2] = ((double)tuner.getProgress() + (double)881)/10;
                }
                else
                {
                    amPresets[2] = tuner.getProgress()+530;
                }
            }
            if(view.getId() == R.id.preset4)
            {
                if (!fm) {
                    fmPresets[3] = ((double)tuner.getProgress() + (double)881)/10;
                }
                else
                {
                    amPresets[3] = tuner.getProgress()+530;
                }
            }
            if(view.getId() == R.id.preset5)
            {
                if (!fm) {
                    fmPresets[4] = ((double)tuner.getProgress() + (double)881)/10;
                }
                else
                {
                    amPresets[4] = tuner.getProgress()+530;
                }
            }
            if(view.getId() == R.id.preset6)
            {
                if (!fm) {
                    fmPresets[5] = ((double)tuner.getProgress() + (double)881)/10;
                }
                else
                {
                    amPresets[5] = tuner.getProgress()+530;
                }
            }
            return false;
        }
    }

    private class presetListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.preset1)
            {
                if (!fm) {
                    display.setText("" + fmPresets[0] + "FM");
                }
                else
                {
                    display.setText("" + amPresets[0] + "AM");
                }
            }
            else if(view.getId() == R.id.preset2)
            {
                if (!fm) {
                    display.setText("" + fmPresets[1] + "FM");
                }
                else
                {
                    display.setText("" + amPresets[1] + "AM");
                }
            }
            else if(view.getId() == R.id.preset3)
            {
                if (!fm) {
                    display.setText("" + fmPresets[2] + "FM");
                }
                else
                {
                    display.setText("" + amPresets[2] + "AM");
                }
            }
            if(view.getId() == R.id.preset4)
            {
                if (!fm) {
                    display.setText("" + fmPresets[3] + "FM");
                }
                else
                {
                    display.setText("" + amPresets[3] + "AM");
                }
            }
            if(view.getId() == R.id.preset5)
            {
                if (!fm) {
                    display.setText("" + fmPresets[4] + "FM");
                }
                else
                {
                    display.setText("" + amPresets[4] + "AM");
                }
            }
            if(view.getId() == R.id.preset6)
            {
                if (!fm) {
                    display.setText("" + fmPresets[5] + "FM");
                }
                else
                {
                    display.setText("" + amPresets[5] + "AM");
                }
            }
        }
    }

    private class seekBarListener implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar t, int progress, boolean b) {
            if (fm){
                display.setText("" + (progress + AMMIN) + "AM");
            }
            else {
                int prevVal, postVal;
                prevVal = (progress + 881)/10;
                postVal = ((progress + 881)%10);
                display.setText("" + prevVal + "." + postVal + "FM");
            }
        }
        public void onStartTrackingTouch(SeekBar seekBar){

        }
        public void onStopTrackingTouch(SeekBar seekBar){

        }
    }
}
