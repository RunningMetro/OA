package model;

public class Rest {
	private Integer id;
	private Integer applyID;
	private Integer approveID;
	private String startTime;
	private String endTime;
	private Integer days;
	private String reason;
	private Integer state;
	private String applyName;
	public Rest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getApplyID() {
		return applyID;
	}
	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}
	public Integer getApproveID() {
		return approveID;
	}
	public void setApproveID(Integer approveID) {
		this.approveID = approveID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	@Override
	public String toString() {
		return "Rest [id=" + id + ", applyID=" + applyID + ", approveID=" + approveID + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", days=" + days + ", reason=" + reason + ", state=" + state + ", applyName="
				+ applyName + "]";
	}
	
}
