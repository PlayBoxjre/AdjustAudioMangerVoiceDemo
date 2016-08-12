package com.example.pc.adjustaudiovoice;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

/**
 * Created by pc on 2016/8/12.
 */
public class AudioVoiceOper {

    private Context context;
    private AudioManager audioManager;

    public AudioVoiceOper(Context context) {
        this.context = context;
        getAudioManager();
    }


    public void getAudioManager() {
        if (audioManager == null)
            audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

    }


    public void voicePlus(int streamType, int flag) {
        audioManager.adjustStreamVolume(streamType, AudioManager.ADJUST_RAISE, flag);
    }

    public void voiceSub(int StreamType, int flag) {
        audioManager.adjustStreamVolume(StreamType, AudioManager.ADJUST_LOWER, flag);
    }

    public void voiceShow(int StreamType, int flag) {
        audioManager.adjustStreamVolume(StreamType, AudioManager.ADJUST_SAME, flag);
    }

    public void voiceMute(int type, int flag) {
        audioManager.unloadSoundEffects();
        audioManager.adjustStreamVolume(type, AudioManager.ADJUST_MUTE, flag);
        audioManager.loadSoundEffects();
    }

    public void voiceUnMute(int type, int flag) {
        audioManager.unloadSoundEffects();
        audioManager.adjustStreamVolume(type, AudioManager.ADJUST_UNMUTE, flag);
        audioManager.loadSoundEffects();
    }


    public void voiceSet(int type, int value, int flag) {
        // audioManager.
        Log.e("manage_", audioManager.getStreamMaxVolume(type) + "");
        audioManager.setStreamVolume(type, audioManager.getStreamMaxVolume(type), flag);

    }
}
