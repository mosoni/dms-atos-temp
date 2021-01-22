create table moi_tracerequest (
	requestId LONG not null primary key,
	requestedBy VARCHAR(75) null,
	requestIncomingDate DATE null,
	requestedConsumerCode VARCHAR(75) null,
	requestedConsumerName VARCHAR(75) null,
	requestedOperation VARCHAR(75) null,
	requestedDocumentType VARCHAR(75) null,
	requestValid BOOLEAN,
	requestResult VARCHAR(500) null,
	requestResultDate DATE null,
	comment_ VARCHAR(500) null
);