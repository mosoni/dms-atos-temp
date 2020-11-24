package com.liferay.appointments.internal.resource.v1_0;

import com.liferay.appointments.dto.v1_0.Appointment;
import com.liferay.appointments.resource.v1_0.AppointmentResource;
import com.liferay.portal.vulcan.pagination.Page;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Javier Gamarra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/appointment.properties",
	scope = ServiceScope.PROTOTYPE, service = AppointmentResource.class
)
public class AppointmentResourceImpl extends BaseAppointmentResourceImpl {
	
	@Override
	public Page<Appointment> getSiteAppointmentsPage(@NotNull Long siteId) throws Exception {
	
		System.out.println("====================================");
		// TODO Auto-generated method stub
		return super.getSiteAppointmentsPage(siteId);
	}
}