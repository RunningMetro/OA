package mapper;

import java.util.List;

import model.Rest;

public interface RestMapper {
	//添加新休假
	public void insertRest(Rest rest);
	//获得所有休假
	public List<Rest> getAllRest();
	//获得指定休假
	public List<Rest> getRest(String applyID);
	//获得指定休假
	public Rest getRestById(String id);
	//审核通过
	public void successRest(String id);
	//审核拒绝
	public void failRest(String id);
}
