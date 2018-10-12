package service;

import java.util.List;

import model.Rest;

public interface IRestService {
	//添加新休假
	public void saveRest(Rest rest);
	//获得所有休假
	public List<Rest> findAllRest();
	//获得指定休假
	public List<Rest> findRest(String applyID);
	//获得指定休假
	public Rest findRestById(String id);
	//审核通过
	public void passRest(String id);
	//审核拒绝
	public void failedRest(String id);
}
