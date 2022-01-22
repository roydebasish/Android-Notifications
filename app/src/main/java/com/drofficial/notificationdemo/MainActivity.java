package com.drofficial.notificationdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    Button buttonSimpleNotification,buttonBigTextNotification,buttonBigPictureNotification,
            buttonInboxStyleNotification,buttonConversationNotification,buttonCustomNotification;

    Message [] messages ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date currentTime = Calendar.getInstance().getTime();

        messages = new Message[5];

        messages[0]=new Message("1",currentTime.getTime(),"This is 1st messages");
        messages[1]=new Message("2",currentTime.getTime(),"This is 2nd messages");
        messages[2]=new Message("3",currentTime.getTime(),"This is 3rd messages");
        messages[3]=new Message("4",currentTime.getTime(),"This is 4th messages");
        messages[4]=new Message("5",currentTime.getTime(),"This is 5th messages");

        createNotificationChannel1();
        createNotificationChannel2();
        createNotificationChannel3();
        createNotificationChannel4();
        createNotificationChannel5();
        createNotificationChannel6();

        buttonSimpleNotification = (Button)findViewById(R.id.buttonSimpleNotification);
        buttonBigTextNotification = (Button)findViewById(R.id.buttonBigTextNotification);
        buttonBigPictureNotification = (Button)findViewById(R.id.buttonBigPictureNotification);
        buttonInboxStyleNotification = (Button)findViewById(R.id.buttonInboxStyleNotification);
        buttonConversationNotification = (Button)findViewById(R.id.buttonConversationNotification);
        buttonCustomNotification = (Button)findViewById(R.id.buttonCustomNotification);

        buttonSimpleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerNotification1();
            }
        });


        buttonBigTextNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerNotification2();
            }
        });


        buttonBigPictureNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerNotification3();
            }
        });


        buttonInboxStyleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerNotification4();
            }
        });


        buttonConversationNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerNotification5();
            }
        });


        buttonCustomNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerNotification6();
            }
        });


    }

    private void createNotificationChannel1(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.CHANNEL_ID1),getString(R.string.CHANNEL_NEWS), NotificationManager.IMPORTANCE_DEFAULT );
            notificationChannel.setDescription(getString(R.string.CHANNEL_DESCRIPTION));
            notificationChannel.setShowBadge(true);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotificationChannel2(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.CHANNEL_ID2),getString(R.string.CHANNEL_GAME), NotificationManager.IMPORTANCE_DEFAULT );
            notificationChannel.setDescription(getString(R.string.CHANNEL_DESCRIPTION));
            notificationChannel.setShowBadge(true);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotificationChannel3(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.CHANNEL_ID3),getString(R.string.CHANNEL_OFFER), NotificationManager.IMPORTANCE_DEFAULT );
            notificationChannel.setDescription(getString(R.string.CHANNEL_DESCRIPTION));
            notificationChannel.setShowBadge(true);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotificationChannel4(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.CHANNEL_ID4),getString(R.string.CHANNEL_INFO), NotificationManager.IMPORTANCE_DEFAULT );
            notificationChannel.setDescription(getString(R.string.CHANNEL_DESCRIPTION));
            notificationChannel.setShowBadge(true);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotificationChannel5(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.CHANNEL_ID5),getString(R.string.CHANNEL_UPDATE), NotificationManager.IMPORTANCE_DEFAULT );
            notificationChannel.setDescription(getString(R.string.CHANNEL_DESCRIPTION));
            notificationChannel.setShowBadge(true);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotificationChannel6(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.CHANNEL_ID6),getString(R.string.CHANNEL_MESSAGE), NotificationManager.IMPORTANCE_DEFAULT );
            notificationChannel.setDescription(getString(R.string.CHANNEL_DESCRIPTION));
            notificationChannel.setShowBadge(true);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void triggerNotification1(){
        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID2))
                .setSmallIcon(R.drawable.ic_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is text, that will be shown as part of notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(getString(R.string.CHANNEL_ID1))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getResources().getInteger(R.integer.notificationId1), builder.build());


    }


    private void triggerNotification2(){
        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID2))
                .setSmallIcon(R.drawable.ic_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is text, that will be shown as part of notification")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(getText(R.string.big_text)))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(getString(R.string.CHANNEL_ID2))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getResources().getInteger(R.integer.notificationId2), builder.build());


    }


    private void triggerNotification3(){
        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID3))
                .setSmallIcon(R.drawable.ic_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is text, that will be shown as part of notification")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.walpaper)))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(getString(R.string.CHANNEL_ID3))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getResources().getInteger(R.integer.notificationId3), builder.build());


    }


    private void triggerNotification4(){
        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID4))
                .setSmallIcon(R.drawable.ic_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is text, that will be shown as part of notification")
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(getText(R.string.massage1))
                        .addLine(getText(R.string.massage2))
                        .addLine(getText(R.string.massage3)))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(getString(R.string.CHANNEL_ID4))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getResources().getInteger(R.integer.notificationId4), builder.build());


    }


    private void triggerNotification5(){
        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

        NotificationCompat.MessagingStyle.Message message1 =
                new NotificationCompat.MessagingStyle.Message(messages[0].getText(),
                        messages[0].getTime(),
                        messages[0].getSender());
        NotificationCompat.MessagingStyle.Message message2 =
                new NotificationCompat.MessagingStyle.Message(messages[1].getText(),
                        messages[1].getTime(),
                        messages[1].getSender());

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID5))
                .setSmallIcon(R.drawable.ic_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is text, that will be shown as part of notification")
                .setStyle(new NotificationCompat.MessagingStyle("Justin")
                        .addMessage(message1)
                        .addMessage(message2))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(getString(R.string.CHANNEL_ID5))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setAutoCancel(true);



        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getResources().getInteger(R.integer.notificationId5), builder.build());


    }


    private void triggerNotification6(){


        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

        RemoteViews customRemoteViews = new RemoteViews(getPackageName(), R.layout.custom_view);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID5))
                .setSmallIcon(R.drawable.ic_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is text, that will be shown as part of notification")
                .setContent(customRemoteViews)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(getString(R.string.CHANNEL_ID5))
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getResources().getInteger(R.integer.notificationId5), builder.build());


    }


}
