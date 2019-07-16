package in.net.usit.springbootangularsecurityapp.service.master;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.net.usit.springbootangularsecurityapp.bointeface.master.ScreenMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.ScreenMaster;
import in.net.usit.springbootangularsecurityapp.repository.master.ScreenMasterRepository;

@Service
public class ScreenMasterService implements ScreenMasterBOInterface {

	@Autowired
	private ScreenMasterRepository repository;
	public ScreenMasterService() {
	}
	@Override
	public List<ScreenMaster> getScreenMasterList() {
		return (List<ScreenMaster>) repository.findAll();
	}
	@Override
	public ScreenMaster saveScreenMaster(ScreenMaster screenMasterMES) {
		repository.save(screenMasterMES);
		return screenMasterMES;
	}
	@Override
	public Optional<ScreenMaster> searchScreenMaster(BigDecimal screenMasterUid) {
		return repository.findById(screenMasterUid);
	}
	@Override
	public int deleteScreenMaster(BigDecimal screenMasterUid) {
		repository.deleteById(screenMasterUid);
		return  1;
	}
	@Override
	public ScreenMaster updateScreenMaster(ScreenMaster screenMasterMES) {
		repository.save(screenMasterMES);
		return screenMasterMES;
	}

}
