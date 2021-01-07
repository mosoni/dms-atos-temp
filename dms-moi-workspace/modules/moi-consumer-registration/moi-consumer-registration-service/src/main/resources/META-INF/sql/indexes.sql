create index IX_FF319ADB on dms_consumer_registration (consumerId[$COLUMN_LENGTH:75$], supportedDocumentType[$COLUMN_LENGTH:75$]);
create index IX_641E6A2B on dms_consumer_registration (consumerName[$COLUMN_LENGTH:75$], supportedDocumentType[$COLUMN_LENGTH:75$]);
create index IX_136B166F on dms_consumer_registration (consumerStatus[$COLUMN_LENGTH:75$]);
create index IX_96B139E0 on dms_consumer_registration (supportedDocumentType[$COLUMN_LENGTH:75$]);