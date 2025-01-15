package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Идентификатор уведомления
    private static final int NOTIFY_ID = 101;

    // Идентификатор канала
    private static String CHANNEL_ID = "Cat channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        button.setOnClickListener(v -> {

            Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);

            //чтобы запускалась запущенная активность, а не создавалась новая
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                    0, notificationIntent,
                    PendingIntent.FLAG_IMMUTABLE);

            Person murzik = null;
            Person vaska  = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                murzik = new Person.Builder().setName("Мурзик").build();
                vaska  = new Person.Builder().setName("Васька").build();

            }

            //нотификация в стиле мессенджера
            NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle
                    (murzik)
                    .setConversationTitle("Android chat")
                    .addMessage("Привет котаны!", System.currentTimeMillis(), murzik)
                    .addMessage("А вы знали, что chat по-французски кошка?", System
                                    .currentTimeMillis(),
                            murzik)
                    .addMessage("Круто!", System.currentTimeMillis(),
                            vaska)
                    .addMessage("Ми-ми-ми", System.currentTimeMillis(), vaska)
                    .addMessage("Мурзик, откуда ты знаешь французский?", System.currentTimeMillis(),
                            vaska)
                    .addMessage("Шерше ля фам, т.е. ищите кошечку!", System.currentTimeMillis(),
                            murzik);

            String bigText = "Это я, почтальон Печкин. Принёс для вас посылку. "
                    + "Только я вам её не отдам. Потому что у вас документов нету. ";

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.cat)
                            .setContentTitle("Напоминание")
                            .setContentText("Пора покормить кота")
                            .setContentIntent(contentIntent)
                            .setColor(ContextCompat.getColor(this, R.color.purple_500))
                            //сейчас можно предложить 3 разных действия в уведомлении, для этого используется  addAction
                            .addAction(R.drawable.cat, "Открыть", contentIntent)
                            //.addAction(R.drawable.cat, "Отказаться", contentIntent)
                            //.addAction(R.drawable.cat, "Другое", contentIntent)
                            //если нужно вывести большой текст полностью
                            //.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                            //аналогично можно сделать уведомление с большой картинкой
//                          .setStyle(new NotificationCompat.BigPictureStyle()
//                              .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.hungrycat)))
                            // можно выводитьк как мессенджер
                            .setStyle(messagingStyle)
                            .setAutoCancel(true)
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            notificationManager.notify(NOTIFY_ID, builder.build());
        });
    }

}