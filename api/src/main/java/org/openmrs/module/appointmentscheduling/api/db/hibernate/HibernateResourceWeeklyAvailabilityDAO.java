package org.openmrs.module.appointmentscheduling.api.db.hibernate;

import org.hibernate.Query;
import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.api.APIException;
import org.openmrs.module.appointmentscheduling.ResourceWeeklyAvailability;
import org.openmrs.module.appointmentscheduling.api.db.ResourceWeeklyAvailabilityDAO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class HibernateResourceWeeklyAvailabilityDAO extends HibernateSingleClassDAO implements ResourceWeeklyAvailabilityDAO {

    /**
     * You must call this before using any of the data access methods, since it's not actually
     * possible to write them all with compile-time class information.
     *
     * @param mappedClass
     */
    protected HibernateResourceWeeklyAvailabilityDAO() {
        super(ResourceWeeklyAvailability.class);
    }

    @Override
    public List<ResourceWeeklyAvailability> getResourceAvailbalityByContraints(Date date, Provider provider, Time time, Location location) {


        String stringQuery = "SELECT ravailability FROM ResourceWeeklyAvailability AS ravailability WHERE voided = 0";

        if (provider != null) {
            stringQuery += " AND ravailability.appointmentResource.provider = :provider";
        }

        if (location != null) {
            stringQuery += " AND ravailability.apAppointmentResourcepointmentResource.location = :location";
        }

        Query query = super.sessionFactory.getCurrentSession().createQuery(stringQuery);

        if (location != null) {
            query.setParameter("location", location);
        }

        if (provider != null) {
            query.setParameter("provider", provider);
        }

        return query.list();
    }
}
