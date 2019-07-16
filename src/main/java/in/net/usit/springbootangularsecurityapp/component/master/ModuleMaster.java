package in.net.usit.springbootangularsecurityapp.component.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Module_Master")
@Data
@Setter
@Getter
//@ToString(callSuper=true, includeFieldNames=true)
//@EqualsAndHashCode(exclude="roleMasterList")
@EqualsAndHashCode(exclude = {"roleMasterList","screenMasterList"})

public class ModuleMaster implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal moduleUid ;
	
	private String moduleId  ;
	private String moduleName;
	private String createdBy  ;
	private String modifiedBy   ;
	private Date createdDate ;
	private Date modifyDate  ;
	private String moduleStatus ; 
	@Transient
	private Boolean select; 

	@JsonManagedReference
	@OneToMany(mappedBy = "moduleMaster", cascade = CascadeType.ALL)
	List<ScreenMaster>screenMasterList= new ArrayList<>();
	
	//@JsonManagedReference
	@ManyToMany(mappedBy = "moduleMasterList", fetch=FetchType.LAZY)
	@JsonIgnoreProperties("roleMasterList")
	private List<RoleMaster> roleMasterList = new ArrayList<>();

/*	@Override
	public String toString() {
		return "ModuleMaster [moduleUid=" + moduleUid + ", moduleId=" + moduleId + ", moduleName=" + moduleName
				+ ", moduleStatus=" + moduleStatus + ", ="  + "]";
	}*/



	


	
	
	
}
