package model;

import java.util.Date;

public class Mail {
	private Integer id;
	private Integer fromID;
	private Integer toID;
	private String titile;
	private String content;
	private String attachment;
	private Integer isread;
	private String createTime;
	private Integer isDelete;
	private String realname;
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFromID() {
		return fromID;
	}
	public void setFromID(Integer fromID) {
		this.fromID = fromID;
	}
	public Integer getToID() {
		return toID;
	}
	public void setToID(Integer toID) {
		this.toID = toID;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public Integer getIsread() {
		return isread;
	}
	public void setIsread(Integer isread) {
		this.isread = isread;
	}

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Mail [id=" + id + ", fromID=" + fromID + ", toID=" + toID + ", titile=" + titile + ", content="
				+ content + ", attachment=" + attachment + ", isread=" + isread + ", createTime=" + createTime
				+ ", isDelete=" + isDelete + ", realname=" + realname + "]";
	}
	
}
