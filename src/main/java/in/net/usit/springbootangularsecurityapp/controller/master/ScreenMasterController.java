package in.net.usit.springbootangularsecurityapp.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.net.usit.springbootangularsecurityapp.bointeface.master.ScreenMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.ModuleMaster;
import in.net.usit.springbootangularsecurityapp.component.master.ScreenMaster;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/screenMaster")

public class ScreenMasterController {

	@Autowired
	private ScreenMasterBOInterface screenMasterService;
	public ScreenMasterController() {
	}
	
	
	
	@RequestMapping(value = "/saveScreenMaster", method = RequestMethod.POST)
	public boolean saveScreenMaster(@RequestBody ScreenMaster screenMaster) {
		System.out.println("<--saveScreenMaster screenMaster: " + screenMaster);
		
		screenMasterService.saveScreenMaster(screenMaster);
		return true;
	}
	@RequestMapping(value = "/screenMasterList")
	public List<ScreenMaster> screenMasterList() {
		System.out.println("i am in screenMasterList in main Controllar");
		List<ScreenMaster> screenMasterList = screenMasterService.getScreenMasterList();
		System.out.println("screenMasterList List Size in Controller: " + screenMasterList.size());
		return screenMasterList;
	}

}
