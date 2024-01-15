package Main;

import java.util.Timer;

import org.apache.commons.lang3.time.StopWatch;

public class TimerO extends Timer {
    private long startTime;
    private int timerLength;
    private long timePaused;
    private StopWatch watch;

    private boolean isSet;
    private boolean isStarted;
    private boolean isPaused;
    private boolean isStopped;

    private TimerO() {
        isSet = false;
        isStarted = false;
        isPaused = false;
        isStopped = false;
    }
    private static TimerO timer;

    public static TimerO getTimer() {
        if(timer == null) {
            timer = new TimerO();
        }
        return timer;
    }

    public boolean getIsSet() {
        return isSet;
    }

    public boolean getIsStarted(){
        return isStarted;
    }

    public boolean getIsPaused() {
        return isPaused;
    }

    public boolean getIsStopped() {
        return isStopped;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTimePaused() {
        return timePaused;
    }
    public int getTimerLength() {
        return timerLength;
    }

    public StopWatch getWatch(){
        return watch;
    }

    public void setSet(boolean set){
        isSet = set;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }
    public void setStartTime(long time){
        startTime = time;
    }
    public void setTimerLength(int length){
        timerLength = length;
    }
    public void setTimePaused(long time){
        timePaused = time;
    }




}
