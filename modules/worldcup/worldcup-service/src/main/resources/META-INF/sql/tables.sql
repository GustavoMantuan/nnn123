create table WorldCup_Group (
	uuid_ VARCHAR(75) null,
	grpId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table WorldCup_Team (
	uuid_ VARCHAR(75) null,
	teamId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	grpId LONG,
	name VARCHAR(75) null
);