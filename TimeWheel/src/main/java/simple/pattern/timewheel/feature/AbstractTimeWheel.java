package simple.pattern.timewheel.feature;

import simple.pattern.timewheel.TimeExpiredHandler;
import simple.pattern.timewheel.TimeScheduler;
import simple.pattern.timewheel.TimeWheel;

/**
 * Created by Saber on 2017/4/15.
 */
public abstract class AbstractTimeWheel implements TimeWheel {

    protected TimeScheduler scheduler = TimeScheduler.Single_Thread_Scheduler;

    protected TimeExpiredHandler timeExpiredHandler = TimeExpiredHandler.Default;

    @Override
    public TimeExpiredHandler getTimeExpiredHandler() {
        return timeExpiredHandler;
    }

    @Override
    public void setTimeExpiredHandler(TimeExpiredHandler timeExpiredHandler) {
        this.timeExpiredHandler = timeExpiredHandler;
    }

    @Override
    public TimeScheduler getScheduler() {
        return scheduler;
    }

    @Override
    public void setScheduler(TimeScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public long getCycleTime() {
        return 0;
    }

    @Override
    public int getClockDial() {
        return 0;
    }
}
