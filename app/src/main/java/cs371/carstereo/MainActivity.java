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

public class MainActivity extends Activity {

    boolean powerOn;
    Button power;
    private TextView display;
    private Button preset1;
    private Button preset2;
    private Button preset3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerOn=true;
        preset1 = (Button) findViewById(R.id.preset1);
        preset2 = (Button) findViewById(R.id.preset2);
        preset3 = (Button) findViewById(R.id.preset3);
        display = (TextView)findViewById(R.id.display);
        power = (Button) findViewById(R.id.power);
        power.setOnClickListener(new powerButtonListener());

    }

    public class powerButtonListener implements View.OnClickListener {

        public void onClick(View v) {

            if(powerOn){
                display.setBackgroundColor(0xFFD3D3D3);
                //powerOn=false;
            }
            else {
                preset1.setBackgroundColor(0xFFFFFFFF);
                preset2.setBackgroundColor(0xFFFFFFFF);
                preset3.setBackgroundColor(0xFFFFFFFF);
                display.setBackgroundColor(0xFF000000);
                //powerOn=true;
            }

            powerOn = !powerOn;
        }
    }
}
