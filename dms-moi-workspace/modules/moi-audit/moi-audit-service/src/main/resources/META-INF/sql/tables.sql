create table moi_audit (
	auditId LONG not null primary key,
	actionPerformedBy VARCHAR(75) null,
	actionPerformedDate DATE null,
	actionStatus VARCHAR(75) null,
	actionDescription VARCHAR(75) null,
	actionConsumer VARCHAR(75) null
);