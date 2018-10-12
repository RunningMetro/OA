package mapper;

import java.util.List;

import model.Rest;

public interface RestMapper {
	//������ݼ�
	public void insertRest(Rest rest);
	//��������ݼ�
	public List<Rest> getAllRest();
	//���ָ���ݼ�
	public List<Rest> getRest(String applyID);
	//���ָ���ݼ�
	public Rest getRestById(String id);
	//���ͨ��
	public void successRest(String id);
	//��˾ܾ�
	public void failRest(String id);
}
