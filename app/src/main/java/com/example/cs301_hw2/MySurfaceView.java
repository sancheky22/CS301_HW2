// @author Kyle Sanchez

package com.example.cs301_hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.concurrent.ThreadLocalRandom;

// MySurfaceView is supposed to be Face Class
public class MySurfaceView extends SurfaceView {


    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    public Paint sColor;
    public Paint eColor;
    public Paint hColor;

    private FaceModel faceModel;


    public MySurfaceView(Context context, AttributeSet attrs){
        super(context,attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);

        sColor =  new Paint();
        skinColor = Color.rgb(241,194,125);
        sColor.setColor(skinColor);

        eColor = new Paint();
        eyeColor = Color.rgb(0,0,0);
        eColor.setColor(eyeColor);

        hColor = new Paint();
        hairColor = Color.rgb(0,0,0);
        hColor.setColor(hairColor);

        faceModel = new FaceModel();

    }

    /**
     External Citation
     Date: 28 September 2019
     Problem: Didn't know how to make random int in specific rnage
     Resource:
     https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     Solution: Used line of example code from stack overflow
     */

    public void randomize(){
        // randomizes ints from 0 to 255 for colors and 1 to 3 for hairstyles
        int randSkin = ThreadLocalRandom.current().nextInt(0,255);
        int randEye = ThreadLocalRandom.current().nextInt(0,255);
        int randHairCol  = ThreadLocalRandom.current().nextInt(0,255);
        int randHairSty =  ThreadLocalRandom.current().nextInt(1,3);
        skinColor = randSkin;
        eyeColor = randEye;
        hairColor = randHairCol;
        hairStyle = randHairSty;

    }

    public void onDraw(Canvas canvas){
        int cx = getWidth() /2;
        int cy = getHeight() /2;
        int rad = getWidth() /8;
        float left = cx - rad/2 - rad/3;
        float right = cx + rad/2 + rad/3;
        float top = cy - rad;
        float bottom = cy - rad/8;

        drawFace(canvas,cx,cy,rad);
        drawEyes(canvas,cx,cy,rad);
        drawHairStyle1(canvas,left,top,right,bottom);

    }

    public void drawFace(Canvas canvas, int cx, int cy, int rad){
        canvas.drawCircle(cx,cy,rad,sColor);
        invalidate();
    }

    public void drawEyes(Canvas canvas, int cx, int cy, int rad){
        canvas.drawCircle(850,400,40,eColor);
        canvas.drawCircle(1050,400,40,eColor);
        invalidate();
    }

    public void drawHairStyle1(Canvas canvas, float left,float top,float right,float bottom){
        canvas.drawArc(left,top,right,bottom,180,180,false,hColor);
        invalidate();
    }

    public void drawHairStyle2(Canvas canvas){
        //canvas.drawRect();
        invalidate();
    }

    public void drawHairStyle3(){
        invalidate();
    }

}
