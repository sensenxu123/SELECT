package pojo;

import java.util.ArrayList;
import java.util.List;


public class PageBean<T> {
	
	//当前页
	private int currentPage;
	//当前页显示的条数
	private int currentCount;
	//总条数
	private int totalCount;
	//总页数
	private int totalPage;




	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public PageBean() {
	}

	public PageBean(int currentPage, int currentCount, int totalCount, int totalPage) {
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
}
