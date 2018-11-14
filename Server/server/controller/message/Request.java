package server.controller.message;

import java.util.List;

import lombok.Data;

@Data
public class Request {
	private String ip; // unboxing ��� ip
	private String id; // unboxing ��� ���� id
	private List<String> newsList; // �޾ƾ� �� ���� ����Ʈ
	private List<String> wantSection; // ���ϴ� ���� ���ǵ�
}
