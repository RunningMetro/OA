package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.RestMapper;
import model.Rest;
import service.IRestService;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
public class RestService implements IRestService {
	@Autowired
	private RestMapper mapper;
	@Override
	public void saveRest(Rest rest) {
		mapper.insertRest(rest);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Rest> findAllRest() {
		return mapper.getAllRest();
	}
	@Override
	@Transactional(readOnly=true)
	public List<Rest> findRest(String applyID) {
		return mapper.getRest(applyID);
	}
	@Override
	@Transactional(readOnly=true)
	public Rest findRestById(String id) {
		return mapper.getRestById(id);
	}
	@Override
	public void passRest(String id) {
		mapper.successRest(id);
	}
	@Override
	public void failedRest(String id) {
		mapper.failRest(id);
	}
}
