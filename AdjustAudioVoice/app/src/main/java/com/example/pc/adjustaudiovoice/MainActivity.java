package com.example.pc.adjustaudiovoice;

import android.media.AudioManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    int flag=AudioManager.FLAG_SHOW_UI;
    private Button plus, sub, set;
    private EditText values;
    private Spinner type_stream;
    private int[] type = {
            AudioManager.STREAM_ALARM,
            AudioManager.STREAM_DTMF,
            AudioManager.STREAM_MUSIC,
            AudioManager.STREAM_NOTIFICATION,
            AudioManager.STREAM_RING,
            AudioManager.STREAM_SYSTEM,
            AudioManager.STREAM_VOICE_CALL

    };
    private int currType = AudioManager.USE_DEFAULT_STREAM_TYPE;
    private AudioVoiceOper audioVoiceOper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioVoiceOper = new AudioVoiceOper(this);

        plus = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.sub);
        set = (Button) findViewById(R.id.set);
        values = (EditText) findViewById(R.id.edit);
        type_stream = (Spinner) findViewById(R.id.spin);

        String[] stringArray = getResources().getStringArray(R.array.stream_type);
        List<String> strings = Arrays.asList(stringArray);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
        type_stream.setAdapter(adapter);

        plus.setOnClickListener(this);
        sub.setOnClickListener(this);
        set.setOnClickListener(this);

        type_stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                currType = MainActivity.this.type[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                voicePlus();
                break;
            case R.id.sub:
                voiceSub();
                break;
            case R.id.set:
                voiceSet();
                break;
        }

    }

    private void voiceSet() {
        String s = values.getText().toString();
        int value = 0;
        if (!TextUtils.isEmpty(s)) {
            value = Integer.parseInt(s);
            audioVoiceOper.voiceSet(currType, value,flag);
        }
    }

    private void voiceSub() {
        audioVoiceOper.voiceSub(currType, flag);
    }

    private void voicePlus() {
        audioVoiceOper.voicePlus(currType, flag);
    }
}
