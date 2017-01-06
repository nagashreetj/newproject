package com.techjini.palettedemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.techjini.palettedemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        binding.htaHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(binding.htaHeader, InputMethodManager.SHOW_IMPLICIT);

            }
        });
        if (myBitmap != null && !myBitmap.isRecycled()) {
            int c=0xffff23;
            Palette palette = Palette.from(myBitmap).generate();
            int color=palette.getMutedColor(c);
         Palette.Swatch swatch=palette.getLightMutedSwatch();
            int color2=swatch.getRgb();

        }
    }
}
