package com.example.materialtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;



public class PictureActivity extends AppCompatActivity {

    public static final String PICTUR_NAME = "picture_name";
    public static final String PICTURE_IMAGE_ID = "picture_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        Intent intent = getIntent();
        String pictureName = intent.getStringExtra(PICTUR_NAME);
        int pictureImageId = intent.getIntExtra(PICTURE_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView pictureImageView = (ImageView)findViewById(R.id.picture_image_view);
        TextView pictureContentText = (TextView)findViewById(R.id.picture_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(pictureName);
        Glide.with(this).load(pictureImageId).into(pictureImageView);
        String pictureContent = generatePictureContent(pictureName);
        pictureContentText.setText(pictureContent);

    }

    private String generatePictureContent(String pictureName){
        StringBuilder pictureContent = new StringBuilder();
        for (int i = 0; i < 500; i++){
            pictureContent.append(pictureName);
        }
        return pictureContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
