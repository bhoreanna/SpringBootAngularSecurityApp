package in.net.usit.springbootangularsecurityapp.bointeface.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import in.net.usit.springbootangularsecurityapp.component.master.RoleMaster;


public interface RoleMasterBOInterface {

	public List<RoleMaster> getRoleMasterList();
	public RoleMaster saveRoleMaster(RoleMaster roleMaster);
	public Optional<RoleMaster> searchRoleMaster(BigDecimal userRoleUid);
	public int deleteRoleMaster(BigDecimal userRoleUid);
	public RoleMaster updateRoleMaster(RoleMaster roleMaster);
}
