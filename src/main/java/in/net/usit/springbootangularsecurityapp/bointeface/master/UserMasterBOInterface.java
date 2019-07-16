package in.net.usit.springbootangularsecurityapp.bointeface.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import in.net.usit.springbootangularsecurityapp.component.master.UserMaster;


public interface UserMasterBOInterface {

	
	public List<UserMaster> getUserMasterList();
	public UserMaster saveUserMaster(UserMaster userMaster);
	public Optional<UserMaster> searchUserMaster(BigDecimal userUid);
	public int deleteUserMaster(BigDecimal userUid);
	public UserMaster updateUserMaster(UserMaster userMaster);
}
