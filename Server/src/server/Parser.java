package server;

import com.google.gson.Gson;

/**
 * Json - Object 변환을 위한 파서 
 * @author lsh
 *
 * @param <T> 변환하고자 하는 객체타입 제네릭 
 */
public interface Parser <T>{
	
	/**
	 * 공용으로 사용되는 Gson 객체 
	 */
	public final static Gson gson = new Gson();
	/**
	 * 
	 * @param obj Json형식의 Response를 만들고자 하는 객체 
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