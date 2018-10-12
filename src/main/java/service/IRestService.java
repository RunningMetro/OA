package service;

import java.util.List;

import model.Rest;

public interface IRestService {
	//������ݼ�
	public void saveRest(Rest rest);
	//��������ݼ�
	public List<Rest> findAllRest();
	//���ָ���ݼ�
	public List<Rest> findRest(String applyID);
	//���ָ���ݼ�
	public Rest findRestById(String id);
	//���ͨ��
	public void passRest(String id);
	//��˾ܾ�
	public void failedRest(String id);
}
