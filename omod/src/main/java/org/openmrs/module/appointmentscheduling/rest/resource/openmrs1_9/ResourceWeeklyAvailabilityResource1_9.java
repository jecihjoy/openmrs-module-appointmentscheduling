package org.openmrs.module.appointmentscheduling.rest.resource.openmrs1_9;

import org.openmrs.api.context.Context;
import org.openmrs.module.appointmentscheduling.AppointmentResource;
import org.openmrs.module.appointmentscheduling.ResourceWeeklyAvailability;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.appointmentscheduling.rest.controller.AppointmentRestController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.annotation.SubResource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.ArrayList;
import java.util.List;

//@SubResource(parent = AppointmentResourceResource1_9.class, path = "resourceweeklyavailability", supportedClass = ResourceWeeklyAvailability.class, supportedOpenmrsVersions = {"2.0.*, 2.1.*, 2.2.*, 2.4.*, 2.8.*"})
@Resource(name = RestConstants.VERSION_1 + AppointmentRestController.APPOINTMENT_SCHEDULING_REST_NAMESPACE + "/resourceweeklyavailability", supportedClass = ResourceWeeklyAvailability.class,
        supportedOpenmrsVersions = {"1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*"})
public class ResourceWeeklyAvailabilityResource1_9 extends DataDelegatingCrudResource<ResourceWeeklyAvailability> {

    @Override
    public ResourceWeeklyAvailability getByUniqueId(String uuid) {
        return Context.getService(AppointmentService.class).getResourceWeeklyAvailability(uuid);
    }

    @Override
    protected void delete(ResourceWeeklyAvailability resourceWeeklyAvailability, String s, RequestContext requestContext) throws ResponseException {

    }

    @Override
    public ResourceWeeklyAvailability newDelegate() {
        return new ResourceWeeklyAvailability();
    }

    @Override
    public ResourceWeeklyAvailability save(ResourceWeeklyAvailability resourceWeeklyAvailability) {
        log.error("resource " +resourceWeeklyAvailability.getAppointmentResource());
        return Context.getService(AppointmentService.class).saveResourceWeeklyAvailability(resourceWeeklyAvailability);
    }

    @Override
    public void purge(ResourceWeeklyAvailability resourceWeeklyAvailability, RequestContext requestContext) throws ResponseException {

    }

    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        if (rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("display", findMethod("getDisplayString"));
            description.addProperty("appointmentResource");
            description.addProperty("monday");
            description.addProperty("tuesday");
            description.addProperty("wednesday");
            description.addProperty("thursday");
            description.addProperty("friday");
            description.addProperty("saturday");
            description.addProperty("sunday");
            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (rep instanceof FullRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("display", findMethod("getDisplayString"));
            description.addProperty("appointmentResource");
            description.addProperty("monday");
            description.addProperty("tuesday");
            description.addProperty("wednesday");
            description.addProperty("thursday");
            description.addProperty("friday");
            description.addProperty("saturday");
            description.addProperty("sunday");
            description.addSelfLink();
            return description;
        }
        return null;
    }

    @Override
    public DelegatingResourceDescription getCreatableProperties() throws ResourceDoesNotSupportOperationException {
        DelegatingResourceDescription description = new DelegatingResourceDescription();
        description.addProperty("appointmentResource");
        description.addProperty("monday");
        description.addProperty("tuesday");
        description.addProperty("wednesday");
        description.addProperty("thursday");
        description.addProperty("friday");
        description.addProperty("saturday");
        description.addProperty("sunday");
        return description;
    }

    @PropertyGetter("display")
    public String getDisplayString(ResourceWeeklyAvailability bdays) {
        return "its monday, shine!";
    }

}