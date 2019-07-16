package in.net.usit.springbootangularsecurityapp.controller.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.net.usit.springbootangularsecurityapp.bointeface.master.UserMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.RoleMaster;
import in.net.usit.springbootangularsecurityapp.component.master.UserMaster;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/userMaster")
public class UserMasterController {

	@Autowired
	private UserMasterBOInterface userMasterService;
	public UserMasterController() {
	}
	
	
	@RequestMapping(value = "/saveUserMaster", method = RequestMethod.POST)
	public boolean saveUserMaster(@RequestBody UserMaster userMaster) {
		
		
		UserMaster user = new UserMaster();
		
		user.setUserId(userMaster.getUserId());
		user.setUserName(userMaster.getUserName());
		user.setPassword(userMaster.getPassword());
		user.setFirstName(userMaster.getFirstName());
		user.setLastName(userMaster.getLastName());
		user.setCreatedBy(userMaster.getCreatedBy());
		user.setCreatedDate(userMaster.getCreatedDate());
		user.setEmail(userMaster.getEmail());
		user.setUserStatus(userMaster.getUserStatus());

		userMasterService.saveUserMaster(user);

		RoleMaster roleMaster = new RoleMaster();
		roleMaster.setRoleUid(userMaster.getRoleMaster().getRoleUid());
		roleMaster.setModuleMasterList(new ArrayList<>());
		user.setRoleMaster(roleMaster);
		
		//userMaster.getRoleMaster().setModuleMasterList(new ArrayList<>());;
		
		System.out.println("--------------------------------------------");
		System.out.println("After: " + user);
		userMasterService.saveUserMaster(user);
		return true;
	}

}
