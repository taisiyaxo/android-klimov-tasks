package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int mCatSound, mChickenSound, mCowSound, mDogSound, mDuckSound, mSheepSound;
    private int mStreamID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cowImageButton = findViewById(R.id.image_cow);
        cowImageButton.setOnClickListener(onClickListener);

        ImageView chickenImageButton = findViewById(R.id.image_chicken);
        chickenImageButton.setOnClickListener(onClickListener);

        ImageView catImageButton = findViewById(R.id.image_cat);
        catImageButton.setOnClickListener(onClickListener);

        ImageView duckImageButton = findViewById(R.id.image_duck);
        duckImageButton.setOnClickListener(onClickListener);

        ImageView sheepImageButton = findViewById(R.id.image_sheep);
        sheepImageButton.setOnClickListener(onClickListener);

        ImageView dogImageButton = findViewById(R.id.image_dog);
        dogImageButton.setOnClickListener(onClickListener);


//        cowImageButton.setOnTouchListener((v, event) -> {
//            int eventAction = event.getAction();
//            if (eventAction == MotionEvent.ACTION_UP) {
//                // Отпускаем палец
//                if (mStreamID > 0)
//                    mSoundPool.stop(mStreamID);
//            }
//            if (eventAction == MotionEvent.ACTION_DOWN) {
//                // Нажимаем на кнопку
//                mStreamID = playSound(mCowSound);
//            }
//            if (event.getAction() == MotionEvent.ACTION_CANCEL) {
//                mSoundPool.stop(mStreamID);
//            }
//            return true;
//        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_cow:
                    playSound(mCowSound);
                    break;
                case R.id.image_chicken:
                    playSound(mChickenSound);
                    break;
                case R.id.image_cat:
                    playSound(mCatSound);
                    break;
                case R.id.image_duck:
                    playSound(mDuckSound);
                    break;
                case R.id.image_sheep:
                    playSound(mSheepSound);
                    break;
                case R.id.image_dog:
                    playSound(mDogSound);
                    break;
            }
        }
    };

    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    @SuppressWarnings("deprecation")
    private void createOldSoundPool() {
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }

    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1, 1, 1, 0, 1);
        }
        return mStreamID;
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Для новых устройств
        createNewSoundPool();

        mAssetManager = getAssets();

        // получим идентификаторы
        mCatSound       = loadSound("cat.wav");
        mChickenSound   = loadSound("chicken.wav");
        mCowSound       = loadSound("cow.wav");
        mDogSound       = loadSound("dog.wav");
        mDuckSound      = loadSound("duck.wav");
        mSheepSound     = loadSound("sheep.wav");

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSoundPool.release();
        mSoundPool = null;
    }

}