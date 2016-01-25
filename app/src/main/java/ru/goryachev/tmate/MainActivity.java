package ru.goryachev.tmate;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_activity);
        blurBackground();
    }

    //Размыть фон "бегущего человека"
    private void blurBackground() {
        Bitmap backgroundBitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.bg);
        Bitmap blurred = Utils.blurRenderScript(this, backgroundBitmap, 25);
        ((ImageView) findViewById(R.id.background)).setImageBitmap(blurred);
    }
}
