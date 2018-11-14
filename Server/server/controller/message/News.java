package server.controller.message;

import lombok.Data;

@Data
public class News {
	private String id; // ���� ���̵�
	private String head_line; //���� ������ 
	private String times; // ���� �ۼ� �� ���� �ð� 
	private String data; // ���� ����
}