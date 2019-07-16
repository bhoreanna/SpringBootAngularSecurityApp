package in.net.usit.springbootangularsecurityapp.service.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.net.usit.springbootangularsecurityapp.bointeface.master.ModuleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.ModuleMaster;
import in.net.usit.springbootangularsecurityapp.repository.master.ModuleMasterRepository;

@Service

public class ModuleMasterService  implements ModuleMasterBOInterface{

	@Autowired
	private ModuleMasterRepository repository;
	public ModuleMasterService() {
	}
	@Override
	public List<ModuleMaster> getModuleMasterList() {
		return (List<ModuleMaster>) repository.findAll();
	}
	@Override
	public ModuleMaster saveModuleMaster(ModuleMaster moduleMaster) {
		repository.save(moduleMaster);
		return moduleMaster;
	}
	@Override
	public Optional<ModuleMaster> searchModuleMaster(BigDecimal moduleUid) {
		return repository.findById(moduleUid);
	}
	@Override
	public int deleteModuleMaster(BigDecimal moduleUid) {
		repository.deleteById(moduleUid);		return 1;
	}
	@Override
	public ModuleMaster updateModuleMaster(ModuleMaster moduleMaster) {
		repository.save(moduleMaster);
		return moduleMaster;
	}

}
