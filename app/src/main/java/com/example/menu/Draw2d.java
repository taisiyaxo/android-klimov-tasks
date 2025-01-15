package com.example.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

public class Draw2d extends View {

    private Paint mPaint = new Paint();
    private Rect  mRect  = new Rect();
    private int   screenWidth;
    private int   screenHeight;

    public Draw2d(Context context, int width, int height) {
        super(context);

        this.screenWidth  = width;
        this.screenHeight = height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        mPaint.setAntiAlias(true);
        // нарисовать желтый круг
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(screenWidth - 50, 30, 25, mPaint);
        //нарисовать зеленый прямоугольник
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, 650, screenWidth, 680, mPaint);
        //написать текс внутри прямоугольника
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        canvas.drawText("Лужайка только для котов", 30, 648, mPaint);

        // Текст под углом
        int x = screenWidth - 190;
        int y = 190;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(27);
        String str2rotate = "Лучик солнца!";

        canvas.save();
        // Создаём ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        canvas.rotate(-45, x + mRect.exactCenterX(), y + mRect.exactCenterY());

        // Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);

        // восстанавливаем холст
        canvas.restore();

    }
}