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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity

@Table(name="Role_Master")
@Data
@Setter
@Getter
//@ToString(callSuper=true, includeFieldNames=true)
//@EqualsAndHashCode(exclude="moduleMasterList")
@EqualsAndHashCode(exclude = {"moduleMasterList"})
public class RoleMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal roleUid;
	
	private String roleId;
	private String roleName;
	private String createdBy  ;
	private String modifiedBy   ;
	private Date createdDate ;
	private Date modifyDate  ;
	private String userRoleStatus;

	
	@JsonIgnoreProperties("userMaster")

	 @OneToOne(mappedBy = "roleMaster")
	    private UserMaster userMaster;
	
	
	//@JsonBackReference
	@JsonIgnoreProperties("moduleMasterList")

	 @ManyToMany(cascade=CascadeType.ALL)	
		    @JoinTable(name = "ROLE_MODULE_Master",joinColumns = @JoinColumn(name = "ROLE_UID"),
		        inverseJoinColumns = @JoinColumn(name = "MODULE_UID")
		    )
		    private List<ModuleMaster> moduleMasterList = new ArrayList<>();


	/*@Override
	public String toString() {
		return "RoleMaster [roleUid=" + roleUid + ", roleId=" + roleId + "]";
	}*/


	
	


	 
	 
	 
}
