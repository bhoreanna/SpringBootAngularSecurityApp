package in.net.usit.springbootangularsecurityapp.controller.master;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import in.net.usit.springbootangularsecurityapp.bointeface.master.ModuleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.ModuleMaster;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/moduleMaster")
public class ModuleMasterController {

	@Autowired
	private ModuleMasterBOInterface moduleMasterService;
	public ModuleMasterController() {
	}
	
	
	@RequestMapping(value = "/saveModuleMaster", method = RequestMethod.POST)
	public boolean saveModuleMaster(@RequestBody ModuleMaster moduleMaster) {
		System.out.println("<--saveModuleMaster moduleMaster: " + moduleMaster.getModuleName());
		
		moduleMasterService.saveModuleMaster(moduleMaster);
		return true;
	}

	
	
	@RequestMapping(value = "/moduleMasterList")
	public List<ModuleMaster> moduleMasterList() {
		System.out.println("i am in moduleMasterList in main Controllar");
		List<ModuleMaster> moduleMasterList = moduleMasterService.getModuleMasterList();
		System.out.println("moduleMasterList List Size in Controller: " + moduleMasterList.size());
		
		List<ModuleMaster> moduleMasterListTemp = new ArrayList<>();
		
		moduleMasterList.forEach(e->{
			ModuleMaster moduleMaster =new ModuleMaster();
			moduleMaster.setModuleUid(e.getModuleUid());
			moduleMaster.setModuleId(e.getModuleId());
			moduleMaster.setModuleName(e.getModuleName());
			moduleMaster.setModifiedBy(e.getCreatedBy());
			moduleMaster.setCreatedDate(e.getCreatedDate());
			moduleMaster.setModuleStatus(e.getModuleStatus());
			moduleMaster.setSelect(false);
			moduleMasterListTemp.add(moduleMaster);
		});
		return moduleMasterListTemp;
	}

}
