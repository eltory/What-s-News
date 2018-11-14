package server;

import com.google.gson.Gson;

/**
 * Json - Object ��ȯ�� ���� �ļ� 
 * @author lsh
 *
 * @param <T> ��ȯ�ϰ��� �ϴ� ��üŸ�� ���׸� 
 */
public interface Parser <T>{
	
	/**
	 * �������� ���Ǵ� Gson ��ü 
	 */
	public final static Gson gson = new Gson();
	/**
	 * 
	 * @param obj Json������ Response�� ������� �ϴ� ��ü 
	 * @return
	 */
	public String makeResponse(T obj);
	/**
	 * 
	 * @param str
	 * @return
	 */
	public T getRequest(String str);
}