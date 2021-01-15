create index IX_B383C413 on moi_idmapper (documentTitle[$COLUMN_LENGTH:75$]);
create index IX_8FF6EA27 on moi_idmapper (fileEntryId[$COLUMN_LENGTH:75$]);
create index IX_6D50C606 on moi_idmapper (mosipCurrentState[$COLUMN_LENGTH:75$]);
create index IX_9C615723 on moi_idmapper (mosipDocumentType[$COLUMN_LENGTH:75$]);
create index IX_7895ECDE on moi_idmapper (registrationId[$COLUMN_LENGTH:75$], mosipCurrentState[$COLUMN_LENGTH:75$]);
create index IX_5B3FDB17 on moi_idmapper (resourceId);
create index IX_1F7F8DE5 on moi_idmapper (updateDate);
create index IX_7E97F948 on moi_idmapper (updatedBy[$COLUMN_LENGTH:75$]);