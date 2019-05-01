package org.openmrs.module.appointmentscheduling.api.db;


import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.module.appointmentscheduling.ResourceWeeklyAvailability;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ResourceWeeklyAvailabilityDAO extends SingleClassDAO {

    List<ResourceWeeklyAvailability> getResourceAvailbalityByContraints(Date date, Provider provider, Time time, Location location);
}
