package in.net.usit.springbootangularsecurityapp.service.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.net.usit.springbootangularsecurityapp.bointeface.master.RoleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.RoleMaster;
import in.net.usit.springbootangularsecurityapp.repository.master.RoleMasterRepository;

@Service

public class RoleMasterService implements RoleMasterBOInterface {
	@Autowired
	private RoleMasterRepository repository;

	public RoleMasterService() {
	}

	@Override
	public List<RoleMaster> getRoleMasterList() {
		return (List<RoleMaster>) repository.findAll();
	}

	@Override
	public RoleMaster saveRoleMaster(RoleMaster roleMaster) {
		repository.save(roleMaster);
		return roleMaster;
	}

	@Override
	public Optional<RoleMaster> searchRoleMaster(BigDecimal userRoleUid) {
		return repository.findById(userRoleUid);
	}

	@Override
	public int deleteRoleMaster(BigDecimal userRoleUid) {
		repository.deleteById(userRoleUid);
		return 1;
	}

	@Override
	public RoleMaster updateRoleMaster(RoleMaster roleMaster) {
		repository.save(roleMaster);
		return null;
	}

}
