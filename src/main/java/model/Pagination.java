package model;

import java.util.List;

public class Pagination {
	//��ǰҳ
	private Integer currentPage;
	//ÿҳ��ʾ�ĸ���
	private Integer pageCount; 
	//���е�ҳ��
	private Integer allPage;
	//��ǰҳ�����ļ���
	private List<Mail> list;
	//���еĸ���
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
