package com.liferay.appointments.internal.resource.v1_0;

import com.liferay.appointments.dto.v1_0.Appointment;
import com.liferay.appointments.dto.v1_0.SiteDocument;
import com.liferay.appointments.resource.v1_0.AppointmentResource;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.vulcan.pagination.Page;

import java.io.File;
import java.io.FileInputStream;

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
	public Page<Appointment> getSiteAppointmentsPage(@NotNull Long siteId)
			throws Exception {

		System.out.println("====================================");
		// TODO Auto-generated method stub
		return super.getSiteAppointmentsPage(siteId);
	}

	@Override
	public SiteDocument getSiteAppointmentDocument(String ModuleType,
			String DocumentType, String Identifier) throws Exception {

		File f = new File(
				"C:\\Users\\A646248\\Desktop\\DMS API and JIRA 0.1");
		System.out.println(f.exists());
		System.out.println(f.length());
		SiteDocument s = new SiteDocument();
		s.setFile(FileUtil.getBytes(f));

		return s;
	}
}