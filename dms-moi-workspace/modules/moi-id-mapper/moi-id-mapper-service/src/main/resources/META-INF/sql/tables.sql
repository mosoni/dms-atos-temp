create table moi_idmapper (
	mapperId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	mosipCurrentState VARCHAR(75) null,
	mosipDocumentType VARCHAR(75) null,
	registrationId VARCHAR(75) null,
	resourceId LONG,
	documentTitle VARCHAR(75) null,
	activeState INTEGER,
	fileEntryId VARCHAR(75) null,
	updateDate DATE null,
	updatedBy VARCHAR(75) null
);