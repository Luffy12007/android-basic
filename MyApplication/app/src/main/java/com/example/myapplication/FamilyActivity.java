package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father","әpә", R.drawable.family_father,
                R.raw.family_father));
        words.add(new Word("mother","әṭa", R.drawable.family_mother,
                R.raw.family_mother));
        words.add(new Word("son","angsi", R.drawable.family_son,
                R.raw.family_son));
        words.add(new Word("daugther","tune",
                R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother","taachi",
                R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti",
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","tete",
                R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti",
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother","ama",
                R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather","paapa",
                R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id ) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}