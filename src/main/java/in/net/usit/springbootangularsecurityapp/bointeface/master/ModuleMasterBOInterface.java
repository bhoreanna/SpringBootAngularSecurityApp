package in.net.usit.springbootangularsecurityapp.bointeface.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import in.net.usit.springbootangularsecurityapp.component.master.ModuleMaster;


public interface ModuleMasterBOInterface {

	
	public List<ModuleMaster> getModuleMasterList();
	public ModuleMaster saveModuleMaster(ModuleMaster moduleMaster);
	public Optional<ModuleMaster> searchModuleMaster(BigDecimal moduleUid);
	public int deleteModuleMaster(BigDecimal moduleUid);
	public ModuleMaster updateModuleMaster(ModuleMaster moduleMaster);
}
