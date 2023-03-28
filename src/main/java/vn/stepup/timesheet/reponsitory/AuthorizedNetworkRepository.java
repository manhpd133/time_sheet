package vn.stepup.timesheet.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.stepup.timesheet.model.AuthorizedNetwork;

@Repository
public interface AuthorizedNetworkRepository  extends JpaRepository<AuthorizedNetwork, Long> {
    AuthorizedNetwork findByIpWifiAndLocation(String ipWifi, String location );
}
