package mashup.kr.mapc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by jeongahri on 2018. 6. 30..
 */

public class MapcWidgetProvider extends AppWidgetProvider{

    private static final String TAG = "HelloWidgetProvider";
    private static final int WIDGET_UPDATE_INTERVAL = 5000;
    private static PendingIntent mSender;
    private static AlarmManager mManager;

    private static int minTemp;
    private static int maxTemp;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        minTemp = 0;
        maxTemp = 50;

        String action = intent.getAction();

        // When [intent - upadating widget] is received
        if(action.equals("android.appwidget.action.APPWIDGET_UPDATE"))
        {
            Log.w(TAG, "android.appwidget.action.APPWIDGET_UPDATE");
            removePreviousAlarm();

            long firstTime = System.currentTimeMillis() + WIDGET_UPDATE_INTERVAL;
            mSender = PendingIntent.getBroadcast(context, 0, intent, 0);
            mManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            mManager.set(AlarmManager.RTC, firstTime, mSender);
        }

        // When [intent - removing widget] is received from users
        else if(action.equals("android.appwidget.action.APPWIDGET_DISABLED"))
        {
            Log.w(TAG, "android.appwidget.action.APPWIDGET_DISABLED");
            removePreviousAlarm();
        }

    }

    /**
     * Widget Update
     */

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        // Getting all the widget lists that produced through this class
        appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, getClass()));
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int N = appWidgetIds.length;
        for(int i = 0 ; i < N ; i++)
        {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);

            //Toast.makeText(context, "onUpdate(): [" + String.valueOf(i) + "] " + String.valueOf(appWidgetId), Toast.LENGTH_SHORT).show();
        }
    }

    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId)
    {
        Date now = new Date();
        RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
        //updateViews.setTextViewText(R.id.temp_space, Integer.toString(maxTemp)+ "° " +"/ "  +Integer.toString(minTemp)+ "°");
        appWidgetManager.updateAppWidget(appWidgetId, updateViews);
    }

    /**
     * Cancel reserved alarms
     */
    public void removePreviousAlarm()
    {
        if(mManager != null && mSender != null)
        {
            mSender.cancel();
            mManager.cancel(mSender);
        }
    }
}
