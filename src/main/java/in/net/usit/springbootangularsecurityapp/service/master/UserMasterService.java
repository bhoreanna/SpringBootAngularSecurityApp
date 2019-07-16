package in.net.usit.springbootangularsecurityapp.service.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.net.usit.springbootangularsecurityapp.bointeface.master.UserMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.UserMaster;
import in.net.usit.springbootangularsecurityapp.repository.master.UserMasterRepository;

@Service

public class UserMasterService implements UserMasterBOInterface {
	@Autowired
	private UserMasterRepository repository;
	public UserMasterService() {
		
	}
	@Override
	public List<UserMaster> getUserMasterList() {
		return (List<UserMaster>) repository.findAll();
	}
	@Override
	public UserMaster saveUserMaster(UserMaster userMaster) {
		 repository.save(userMaster);
		return userMaster;
	}
	@Override
	public Optional<UserMaster> searchUserMaster(BigDecimal userUid) {
		return repository.findById(userUid);
	}
	@Override
	public int deleteUserMaster(BigDecimal userUid) {
		repository.deleteById(userUid);
		return 1;
	}
	@Override
	public UserMaster updateUserMaster(UserMaster userMaster) {
		repository.save(userMaster);
		return null;
	}

}
