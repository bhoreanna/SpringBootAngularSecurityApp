package in.net.usit.springbootangularsecurityapp.repository.master;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import in.net.usit.springbootangularsecurityapp.component.master.ScreenMaster;

@Repository

public interface ScreenMasterRepository extends CrudRepository<ScreenMaster , BigDecimal> {

}
