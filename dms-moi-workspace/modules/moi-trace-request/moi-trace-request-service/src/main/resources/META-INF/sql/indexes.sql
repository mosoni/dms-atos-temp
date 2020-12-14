create index IX_39A0FC6B on moi_tracerequest (requestIncomingDate);
create index IX_5472DD14 on moi_tracerequest (requestResult[$COLUMN_LENGTH:75$]);
create index IX_2736C462 on moi_tracerequest (requestResultDate);
create index IX_31F3252D on moi_tracerequest (requestedBy[$COLUMN_LENGTH:75$]);
create index IX_D7956BD9 on moi_tracerequest (requestedConsumerCode[$COLUMN_LENGTH:75$]);
create index IX_E99988F7 on moi_tracerequest (requestedConsumerName[$COLUMN_LENGTH:75$]);
create index IX_F65B36F5 on moi_tracerequest (requestedOperation[$COLUMN_LENGTH:75$]);