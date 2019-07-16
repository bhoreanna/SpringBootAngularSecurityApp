package in.net.usit.springbootangularsecurityapp.controller.master;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;
import in.net.usit.springbootangularsecurityapp.bointeface.master.ModuleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.bointeface.master.RoleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.ModuleMaster;
import in.net.usit.springbootangularsecurityapp.component.master.RoleMaster;
import in.net.usit.springbootangularsecurityapp.component.master.ScreenMaster;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/roleMaster")
public class RoleMasterController {
	
	@Autowired
	private RoleMasterBOInterface roleMasterService;
	

	@Autowired
	private ModuleMasterBOInterface  moduleMasterService;
	
	public RoleMasterController() {
		
	}
	
	//http://localhost:4200/roleMaster/roleMasterList
	
	@RequestMapping(value = "/roleMasterList")
	public List<RoleMaster> roleMasterList() {
		System.out.println("i am in roleMasterList in main Controllar");
		List<RoleMaster> roleMasterList = roleMasterService.getRoleMasterList();
		System.out.println("roleMasterList List Size in Controller: " + roleMasterList.size());
		
		List<RoleMaster> roleMasterListTemp = new ArrayList<>();
		roleMasterList.forEach(s->{
			RoleMaster r1= new RoleMaster();
			r1.setRoleUid(s.getRoleUid());
			r1.setRoleId(s.getRoleId());
			r1.setRoleName(s.getRoleName());
			r1.setCreatedBy(s.getCreatedBy());
			r1.setCreatedDate(s.getCreatedDate());
			r1.setUserRoleStatus(s.getUserRoleStatus());
			roleMasterListTemp.add(r1);
		});
		return roleMasterListTemp;
	//	return roleMasterList;
	}
	
	
	
	
	@RequestMapping(value = "/saveRoleMaster", method = RequestMethod.POST)
	public boolean saveRoleMaster(@RequestBody RoleMaster roleMaster) {
		
	List<ModuleMaster> temp = roleMaster.getModuleMasterList();
	List<ModuleMaster> moduleList = new ArrayList<>();
	moduleList.addAll(temp);
			//moduleMasterService.getModuleMasterList();
	System.out.println(" moduleList size  "+moduleList.size());
		
	for (ModuleMaster moduleMaster : moduleList) {
		System.out.println("-->moduleList "+moduleMaster.getModuleUid()+" "+moduleMaster.getModuleName());
		moduleMaster.getScreenMasterList().forEach(s->System.out.println(" ScreenMasterLis uid  "+s.getScreenUid()+" name "+s.getScreenName()));
	}
	
	
	roleMaster.setModuleMasterList(new ArrayList<>());
	//	roleMaster.getModuleMasterList().addAll(moduleList);
		
		System.out.println("<--saveRoleMaster roleMaster: " + roleMaster.getRoleId()+" "+roleMaster.getRoleUid());
		
		
		
		roleMasterService.saveRoleMaster(roleMaster);
		roleMaster.setModuleMasterList(moduleList);
		roleMasterService.saveRoleMaster(roleMaster);

		return true;
	}

}
