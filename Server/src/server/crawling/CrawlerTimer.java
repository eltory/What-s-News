package server.crawling;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 각 섹션모듈별로 수행시간을 조절하기 위한 인터페이스
 * @author lsh
 *
 */
public interface CrawlerTimer {
	static final Timer t = new Timer();

	/**
	 * 반복실행 주기를 설정함
	 * @param time
	 */
	public void setPeriod(long time);

	/**
	 * 반복실행 주기를 계산함
	 * @param time
	 * @return 계산된 주기 
	 */
	public long calPeriod(long time);

	/**
	 * 설정 주기마다 Task를 실행하기 위함
	 * @param task
	 * @param firstTime
	 * @param period
	 * @return 실행 완료여부 
	 */
	public boolean doTask(TimerTask task, Date firstTime, long period);

	/**
	 * 이전 시간을 저장 
	 * @param time
	 */
	public void saveTime(long time);

	/**
	 * 저장된 시간 반환 
	 * @param time
	 * @return 저장된 마지막 시간 
	 */
	public long loadTime(long time);
}