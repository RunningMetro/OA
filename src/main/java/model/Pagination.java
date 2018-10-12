package model;

import java.util.List;

public class Pagination {
	//当前页
	private Integer currentPage;
	//每页显示的个数
	private Integer pageCount; 
	//所有的页数
	private Integer allPage;
	//当前页数量的集合
	private List<Mail> list;
	//所有的个数
	private Integer allCount;
	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getAllPage() {
		return allPage;
	}
	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}
	public List<Mail> getList() {
		return list;
	}
	public void setList(List<Mail> list) {
		this.list = list;
	}
	public Integer getAllCount() {
		return allCount;
	}
	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}
	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", pageCount=" + pageCount + ", allPage=" + allPage
				+ ", list=" + list + ", allCount=" + allCount + "]";
	}
	
	
	
	
}
