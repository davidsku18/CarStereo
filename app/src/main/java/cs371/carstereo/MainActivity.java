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

    boolean powerOn;
    boolean am;
    double base = 100;
    private double amR;
    private double fmR;
    ToggleButton power;
    SeekBar tuner;
    private TextView display;
    private Button preset1;
    private Button preset2;
    private Button preset3;
    int AMMIN = 530;
    int AMMAX = 1700;
    int FMMIN = 881;
    int FMMAX = 1079;
    int amProg=0;
    int fmProg=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerOn=true;

        preset1 = (Button) findViewById(R.id.preset1);
        preset2 = (Button) findViewById(R.id.preset2);
        preset3 = (Button) findViewById(R.id.preset3);
        display = (TextView)findViewById(R.id.display);
        power = (ToggleButton) findViewById(R.id.power);
        power.setOnClickListener(new powerButtonListener());



        tuner = (SeekBar)findViewById(R.id.tuner);
        tuner.setOnSeekBarChangeListener(new seekBarListener());

    }

    public class powerButtonListener implements View.OnClickListener {

        public void onClick(View v) {

            if(powerOn){
                display.setBackgroundColor(0xFFD3D3D3);
                preset1.setBackgroundColor(0xFFFFFFFF);
                preset2.setBackgroundColor(0xFFFFFFFF);
                preset3.setBackgroundColor(0xFFFFFFFF);
                //powerOn=false;
            }
            else {
                preset1.setBackgroundColor(0xFF000000);
                preset2.setBackgroundColor(0xFF000000);
                preset3.setBackgroundColor(0xFF000000);
                display.setBackgroundColor(0xFF000000);
                //powerOn=true;
            }

            powerOn = !powerOn;

        }
    }

    public void amListener(View v){
        if (am)
        {
            amProg = tuner.getProgress();
            tuner.setMax((int)(AMMAX-AMMIN));
            tuner.setProgress(amProg);
        }
        else
        {
            fmProg = tuner.getProgress();
            tuner.setMax((int)(FMMAX-FMMIN));
            tuner.setProgress(fmProg);
        }
        am=!am;
    }

    private class seekBarListener implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar t, int i, boolean b) {
            int amVal = AMMIN + amProg;
            double fmVal = (double) ((FMMIN + fmProg) / 10);
            if (am) {
                amProg = tuner.getProgress();
                display.setText("" + amVal);
            } else {
                fmProg = tuner.getProgress();
                display.setText("" + fmVal);
            }
        }
        public void onStartTrackingTouch(SeekBar seekBar){

        }
        public void onStopTrackingTouch(SeekBar seekBar){

        }
    }
}
