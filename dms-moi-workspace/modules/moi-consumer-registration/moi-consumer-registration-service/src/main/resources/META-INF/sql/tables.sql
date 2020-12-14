create table dms_consumer_registration (
	registrationId LONG not null primary key,
	consumerId VARCHAR(75) null,
	consumerName VARCHAR(75) null,
	consumerDescription STRING null,
	supportedDocumentType VARCHAR(75) null,
	consumerStatus VARCHAR(75) null
);