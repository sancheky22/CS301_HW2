// @author Kyle Sanchez

package com.example.cs301_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    public int hairStyle = 1;
    private FaceModel faceModel;

    /**
     External Citation
     Date: 26 September 2019
     Problem: Didn't know how to use Radio Groups and Buttons
     Resource:
     https://developer.android.com/reference/android/widget/RadioGroup?hl=en
     Solution: I read the documentation to learn how to use radio groups/buttons
     */

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        /**
         External Citation
         Date: 26 September 2019
         Problem: Didn't know how to use Spinners
         Resource:
         https://developer.android.com/guide/topics/ui/controls/spinner
         Solution: I read the documentation to learn how to use spinners
         */

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.hairStyles,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        radioGroup = findViewById(R.id.radioGroup);



    }
    /**
     External Citation
     Date: 28 September 2019
     Problem: Wanted to know how to use toasts
     Resource:
     https://developer.android.com/guide/topics/ui/notifiers/toasts
     Solution: I read the documentation to learn how to use toasts
     */

    public void checkedButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this,"Selected Radio Button: " + radioButton.getText(),Toast.LENGTH_SHORT).show();
    }

    // Spinner listeners
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getSelectedItem().toString();
        // Adds a toast whenever spinner is selcted

        // set hairstyles to corresponding spinner
       /**if(text.equals("Style1")){
           faceModel.hairStyle = 1;
       }else if(text.equals("Style2")){
           faceModel.hairStyle = 2;
       }else if(text.equals("Style3")){
           faceModel.hairStyle = 3;
       }
      */
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    // Button listener
    @Override
    public void onClick(View view) {
        
    }


    // Seekbar listeners
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
