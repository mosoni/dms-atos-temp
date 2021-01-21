create table moi_deletedocuments (
	documentId LONG not null primary key,
	fileEntryId LONG,
	fileEntryName VARCHAR(75) null,
	consumerCode VARCHAR(75) null,
	moduleType VARCHAR(75) null,
	uploadedBy VARCHAR(75) null,
	uploadedDate DATE null,
	status VARCHAR(75) null,
	comments VARCHAR(75) null,
	updatedBy VARCHAR(75) null,
	updatedDate DATE null,
	pendingIdentifiers VARCHAR(75) null
);