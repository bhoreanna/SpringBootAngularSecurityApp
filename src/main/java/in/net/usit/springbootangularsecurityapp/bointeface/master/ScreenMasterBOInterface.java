package in.net.usit.springbootangularsecurityapp.bointeface.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


import in.net.usit.springbootangularsecurityapp.component.master.ScreenMaster;

public interface ScreenMasterBOInterface {

	
	public List<ScreenMaster> getScreenMasterList();
	public ScreenMaster saveScreenMaster(ScreenMaster screenMaster);
	public Optional<ScreenMaster> searchScreenMaster(BigDecimal screenMasterUid);
	public int deleteScreenMaster(BigDecimal screenMasterUid);
	public ScreenMaster updateScreenMaster(ScreenMaster screenMaster);
	
}
