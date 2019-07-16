package in.net.usit.springbootangularsecurityapp.component.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Screen_Master")
@Data
@Setter
@Getter
//@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode(exclude = {"moduleMaster"})

public class ScreenMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal screenUid  ;
	
	private String screenId   ;
	private String screenName;
	private String createdBy  ;
	private String modifiedBy   ;
	private Date createdDate ;
	private Date modifyDate  ;
	private String screenStatus ; 
	
	@JsonBackReference
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "moduleUid" )
	private ModuleMaster moduleMaster;

/*	@Override
	public String toString() {
		return "ScreenMaster [screenUid=" + screenUid + ", screenId=" + screenId + ", screenName=" + screenName + "]";
	}*/
	
	
	
}
