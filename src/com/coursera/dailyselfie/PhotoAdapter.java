
package com.coursera.dailyselfie;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoAdapter extends ArrayAdapter<File> {

    private Context mContext;
    
    public PhotoAdapter(Context context, File[] values) {
        super(context, R.layout.row_photo, values);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_photo, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.name_text_view);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.photo_image_view);
        final File file = getItem(position);
        textView.setText(file.getName());
        imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        rowView.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.FILE_PATH, file.getAbsolutePath());
                mContext.startActivity(intent);
            }
        });
        return rowView;
    }
}
