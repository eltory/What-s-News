package server.crawling;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �� ���Ǹ�⺰�� ����ð��� �����ϱ� ���� �������̽�
 * @author lsh
 *
 */
public interface CrawlerTimer {
	static final Timer t = new Timer();

	/**
	 * �ݺ����� �ֱ⸦ ������
	 * @param time
	 */
	public void setPeriod(long time);

	/**
	 * �ݺ����� �ֱ⸦ �����
	 * @param time
	 * @return ���� �ֱ� 
	 */
	public long calPeriod(long time);

	/**
	 * ���� �ֱ⸶�� Task�� �����ϱ� ����
	 * @param task
	 * @param firstTime
	 * @param period
	 * @return ���� �ϷῩ�� 
	 */
	public boolean doTask(TimerTask task, Date firstTime, long period);

	/**
	 * ���� �ð��� ���� 
	 * @param time
	 */
	public void saveTime(long time);

	/**
	 * ����� �ð� ��ȯ 
	 * @param time
	 * @return ����� ������ �ð� 
	 */
	public long loadTime(long time);
}