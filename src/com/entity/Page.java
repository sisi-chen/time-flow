package com.entity;

public class Page {
   private int page=1;//当前页数
   private int pageSize=6;//每页显示几条数据
   
/*
 * 分页中的算法：(page-1)*pageSize
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
