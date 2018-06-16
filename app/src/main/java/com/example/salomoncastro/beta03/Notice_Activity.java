package com.example.salomoncastro.beta03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Notice_Activity extends AppCompatActivity {

    private TextView tvTitle, tvDescription, tvCategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_);

        tvTitle = (TextView) findViewById(R.id.txtTitle);
        tvDescription = (TextView) findViewById(R.id.txtDescription);
        tvCategory = (TextView) findViewById(R.id.txtCategory);

        img = (ImageView)findViewById(R.id.noticeThumbnail);

        //Recieve data

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        //Setting values

        tvTitle.setText(Title);
        tvDescription.setText(Description);
        img.setImageResource(image);


    }
}
