package com.course.timer;

import java.util.Date;
import java.util.Timer;

import org.springframework.stereotype.Component;

@Component
public class ChooseCourseTimer {
	private volatile boolean chooseState;
	private volatile boolean isTimerRun;
	private Timer timer;
	private Date startDate;

	private void init() {
		chooseState = false;
		if (null != timer) {
			timer.cancel();
			timer = null;
		}
		if (null == startDate)
			startDate = null;
		isTimerRun = false;
	}

	public void startAt(Date startDate) throws Exception {
		long delay = getDelay(startDate);
		init();
		timer = new Timer();
		TimerTask task = new TimerTask(this);
		timer.schedule(task, delay);
		isTimerRun = true;
	}

	private long getDelay(Date startDate) throws Exception {
		long d_value = startDate.getTime() - System.currentTimeMillis();
		if (d_value < 1000 * 60 * 3)
			throw new Exception("选课开始时间至少在3分钟之后。");
		this.startDate = startDate;
		return d_value;
	}

	public boolean getChooseState() {
		return this.chooseState;
	}

	public boolean isTimerRun() {
		return this.isTimerRun;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	private class TimerTask extends java.util.TimerTask {

		ChooseCourseTimer timer;

		TimerTask(ChooseCourseTimer timer) {
			this.timer = timer;
		}

		@Override
		public void run() {
			timer.chooseState = true;
			timer.timer.cancel();
			timer.timer = null;
			timer.isTimerRun = false;
		}

	}

}
