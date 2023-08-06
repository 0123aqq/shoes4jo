package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkC {
	private int bookmark_id;
	private String member_id;
	private String start_date;
	private String end_date;
	private String time_unit;
	private String category;
	private String category_name;
	private String category_param;
	private String device;
	private String gender;
	private String ages;
	private String add_date;
}



     /* @Component ������̼��� ������ �����ӿ�ũ���� ���Ǹ�, Ŭ������ ������ ������ ����ϰ�, ���� �̸��� �����ϴ� ����
     *(�� �̸��� �ٸ� ����� �ش� ������Ʈ�� ������ ������ ��û�� �� ���)
     *
	 * @Data: Ŭ������ �� ������̼��� ����ϸ� �ڵ����� getter,setter,toString(), equals() �� hashCode() �޼��� ����
	 * 
	 * @NoArgsConstructor: ���ڰ� ���� �⺻ �����ڸ� �ڵ����� ����
	 * 
	 * @AllArgsConstructor: ��� �ʵ� ���� ���ڷ� ���� �����ڸ� �ڵ����� ����. Ŭ������ ��� ��� ������ �ʱ�ȭ
	 */