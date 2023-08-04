package com.multi.shoes4jo.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkC {
	private int BookMarkID;
	private String MemberID;
	private String StartDate;
	private String EndDate;
	private String TimeUnit;
	private String Category;
	private String CategoryName;
	private String CategoryParam;
	private String Device;
	private String Gender;
	private String Ages;
	private String AddDate;
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