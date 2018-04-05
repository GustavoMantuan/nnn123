create index IX_DD9AD4D1 on WorldCup_Group (name[$COLUMN_LENGTH:75$]);
create index IX_D111FC06 on WorldCup_Group (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E8D5CC08 on WorldCup_Group (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_21E31875 on WorldCup_Team (name[$COLUMN_LENGTH:75$]);
create index IX_FFFDE9AA on WorldCup_Team (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B068D2AC on WorldCup_Team (uuid_[$COLUMN_LENGTH:75$], groupId);