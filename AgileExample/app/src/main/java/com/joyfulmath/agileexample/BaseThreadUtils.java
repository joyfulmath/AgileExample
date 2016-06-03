package com.joyfulmath.agileexample;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author deman.lu
 * @version on 2016-06-03 11:15
 */
public class BaseThreadUtils {
    protected static ExecutorService pool = Executors.newFixedThreadPool(4);
    protected static Handler mMainHandler = new Handler(Looper.getMainLooper());
    protected static Handler workHandler = null;

    protected static HandlerThread handlerThread = new HandlerThread("work"){
        @Override
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            workHandler = new Handler(Looper.myLooper());
        }
    };


    public static void doBackground(Runnable runnable)
    {
        pool.execute(runnable);
    }


    public static void UpdateInMainThread(Runnable runnable)
    {
        if(mMainHandler!=null)
        {
            mMainHandler.post(runnable);
        }
    }

    public static void initWorkThread()
    {
        handlerThread.start();
    }

    public static void releaseWorkThread()
    {
        handlerThread.quit();
    }

    public static void runInWorkThread(Runnable runnable)
    {
        if(workHandler!=null)
        {
            workHandler.post(runnable);
        }
    }

    public void UpdateInMainThreadDelay(Runnable runnable,long millis)
    {
        if(mMainHandler!=null)
        {
            mMainHandler.postDelayed(runnable, millis);
        }
    }

    public void checkBackground()
    {
        if(Looper.getMainLooper() == Looper.myLooper())
        {
            throw new RuntimeException("it must be running in work thread!");
        }
    }

}
