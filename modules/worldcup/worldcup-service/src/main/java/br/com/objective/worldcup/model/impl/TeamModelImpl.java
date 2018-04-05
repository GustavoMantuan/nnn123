/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.objective.worldcup.model.impl;

import aQute.bnd.annotation.ProviderType;

import br.com.objective.worldcup.model.Team;
import br.com.objective.worldcup.model.TeamModel;
import br.com.objective.worldcup.model.TeamSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Team service. Represents a row in the &quot;WorldCup_Team&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TeamModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TeamImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamImpl
 * @see Team
 * @see TeamModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TeamModelImpl extends BaseModelImpl<Team> implements TeamModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a team model instance should use the {@link Team} interface instead.
	 */
	public static final String TABLE_NAME = "WorldCup_Team";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "teamId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "grpId", Types.BIGINT },
			{ "name", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("teamId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("grpId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table WorldCup_Team (uuid_ VARCHAR(75) null,teamId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,grpId LONG,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table WorldCup_Team";
	public static final String ORDER_BY_JPQL = " ORDER BY team.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WorldCup_Team.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(br.com.objective.worldcup.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.br.com.objective.worldcup.model.Team"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(br.com.objective.worldcup.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.br.com.objective.worldcup.model.Team"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(br.com.objective.worldcup.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.br.com.objective.worldcup.model.Team"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long NAME_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Team toModel(TeamSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Team model = new TeamImpl();

		model.setUuid(soapModel.getUuid());
		model.setTeamId(soapModel.getTeamId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setGrpId(soapModel.getGrpId());
		model.setName(soapModel.getName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Team> toModels(TeamSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Team> models = new ArrayList<Team>(soapModels.length);

		for (TeamSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(br.com.objective.worldcup.service.util.ServiceProps.get(
				"lock.expiration.time.br.com.objective.worldcup.model.Team"));

	public TeamModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _teamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTeamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _teamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Team.class;
	}

	@Override
	public String getModelClassName() {
		return Team.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("teamId", getTeamId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("grpId", getGrpId());
		attributes.put("name", getName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long teamId = (Long)attributes.get("teamId");

		if (teamId != null) {
			setTeamId(teamId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long grpId = (Long)attributes.get("grpId");

		if (grpId != null) {
			setGrpId(grpId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTeamId() {
		return _teamId;
	}

	@Override
	public void setTeamId(long teamId) {
		_teamId = teamId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getGrpId() {
		return _grpId;
	}

	@Override
	public void setGrpId(long grpId) {
		_grpId = grpId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Team.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Team.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Team toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Team)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TeamImpl teamImpl = new TeamImpl();

		teamImpl.setUuid(getUuid());
		teamImpl.setTeamId(getTeamId());
		teamImpl.setGroupId(getGroupId());
		teamImpl.setCompanyId(getCompanyId());
		teamImpl.setUserId(getUserId());
		teamImpl.setUserName(getUserName());
		teamImpl.setCreateDate(getCreateDate());
		teamImpl.setModifiedDate(getModifiedDate());
		teamImpl.setGrpId(getGrpId());
		teamImpl.setName(getName());

		teamImpl.resetOriginalValues();

		return teamImpl;
	}

	@Override
	public int compareTo(Team team) {
		int value = 0;

		value = getName().compareTo(team.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Team)) {
			return false;
		}

		Team team = (Team)obj;

		long primaryKey = team.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TeamModelImpl teamModelImpl = this;

		teamModelImpl._originalUuid = teamModelImpl._uuid;

		teamModelImpl._originalGroupId = teamModelImpl._groupId;

		teamModelImpl._setOriginalGroupId = false;

		teamModelImpl._originalCompanyId = teamModelImpl._companyId;

		teamModelImpl._setOriginalCompanyId = false;

		teamModelImpl._setModifiedDate = false;

		teamModelImpl._originalName = teamModelImpl._name;

		teamModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Team> toCacheModel() {
		TeamCacheModel teamCacheModel = new TeamCacheModel();

		teamCacheModel.uuid = getUuid();

		String uuid = teamCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			teamCacheModel.uuid = null;
		}

		teamCacheModel.teamId = getTeamId();

		teamCacheModel.groupId = getGroupId();

		teamCacheModel.companyId = getCompanyId();

		teamCacheModel.userId = getUserId();

		teamCacheModel.userName = getUserName();

		String userName = teamCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			teamCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			teamCacheModel.createDate = createDate.getTime();
		}
		else {
			teamCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			teamCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			teamCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		teamCacheModel.grpId = getGrpId();

		teamCacheModel.name = getName();

		String name = teamCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			teamCacheModel.name = null;
		}

		return teamCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", teamId=");
		sb.append(getTeamId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", grpId=");
		sb.append(getGrpId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("br.com.objective.worldcup.model.Team");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>teamId</column-name><column-value><![CDATA[");
		sb.append(getTeamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grpId</column-name><column-value><![CDATA[");
		sb.append(getGrpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Team.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Team.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _teamId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _grpId;
	private String _name;
	private String _originalName;
	private long _columnBitmask;
	private Team _escapedModel;
}