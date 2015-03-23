
package com.coursera.dailyselfie;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

public class DetailActivity extends ActionBarActivity {

    public static final String FILE_PATH = "file_path";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        ImageView imageView = (ImageView) findViewById(R.id.photo_image_view);
        
        String filePath = getIntent().getStringExtra(FILE_PATH);
        imageView.setImageBitmap(BitmapFactory.decodeFile(filePath));
    }

}
