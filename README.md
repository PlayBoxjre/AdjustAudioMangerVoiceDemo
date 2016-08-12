# AdjustAudioMangerVoiceDemo
---

- description:
  > this is a demo about adjusting voice of mobile phone. because it is so easily.Only to use to study for me.English is not ok. 

  - AudioManager 类 用来处理声音的信息。
  
    ```
      AudioManager am = (AudioManager) context.getSystemServer(Context.AUDIO_SERVER);
    ```
    
  - method 
    
    ```
       am.adjustStreamVolume (AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
       
       
        am.setStreamVolume (AudioManager.STREAM_MUSIC,30, AudioManager.FLAG_SHOW_UI);
    ```
    
    
