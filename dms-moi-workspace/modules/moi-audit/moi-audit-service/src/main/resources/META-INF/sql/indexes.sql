create index IX_F5B92869 on moi_audit (actionConsumer[$COLUMN_LENGTH:75$]);
create index IX_4C13F1CD on moi_audit (actionDescription[$COLUMN_LENGTH:75$]);
create index IX_F3A70348 on moi_audit (actionPerformedBy[$COLUMN_LENGTH:75$]);
create index IX_A82D891F on moi_audit (actionPerformedDate);
create index IX_9DB7A1A5 on moi_audit (actionStatus[$COLUMN_LENGTH:75$]);