package com.entity;

public class Page {
   private int page=1;//��ǰҳ��
   private int pageSize=6;//ÿҳ��ʾ��������
   
/*
 * ��ҳ�е��㷨��(page-1)*pageSize
 */
public int getBegin(){
	int begin=(page-1)*pageSize;
	return begin;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
   
}
