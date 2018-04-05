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

package com.objective.worldcup.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Group}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Group
 * @generated
 */
@ProviderType
public class GroupWrapper implements Group, ModelWrapper<Group> {
	public GroupWrapper(Group group) {
		_group = group;
	}

	@Override
	public Class<?> getModelClass() {
		return Group.class;
	}

	@Override
	public String getModelClassName() {
		return Group.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("grpId", getGrpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long grpId = (Long)attributes.get("grpId");

		if (grpId != null) {
			setGrpId(grpId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public Group toEscapedModel() {
		return new GroupWrapper(_group.toEscapedModel());
	}

	@Override
	public Group toUnescapedModel() {
		return new GroupWrapper(_group.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _group.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _group.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _group.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _group.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Group> toCacheModel() {
		return _group.toCacheModel();
	}

	@Override
	public int compareTo(Group group) {
		return _group.compareTo(group);
	}

	@Override
	public int hashCode() {
		return _group.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _group.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GroupWrapper((Group)_group.clone());
	}

	/**
	* Returns the name of this group.
	*
	* @return the name of this group
	*/
	@Override
	public java.lang.String getName() {
		return _group.getName();
	}

	/**
	* Returns the user name of this group.
	*
	* @return the user name of this group
	*/
	@Override
	public java.lang.String getUserName() {
		return _group.getUserName();
	}

	/**
	* Returns the user uuid of this group.
	*
	* @return the user uuid of this group
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _group.getUserUuid();
	}

	/**
	* Returns the uuid of this group.
	*
	* @return the uuid of this group
	*/
	@Override
	public java.lang.String getUuid() {
		return _group.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _group.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _group.toXmlString();
	}

	/**
	* Returns the create date of this group.
	*
	* @return the create date of this group
	*/
	@Override
	public Date getCreateDate() {
		return _group.getCreateDate();
	}

	/**
	* Returns the modified date of this group.
	*
	* @return the modified date of this group
	*/
	@Override
	public Date getModifiedDate() {
		return _group.getModifiedDate();
	}

	/**
	* Returns the company ID of this group.
	*
	* @return the company ID of this group
	*/
	@Override
	public long getCompanyId() {
		return _group.getCompanyId();
	}

	/**
	* Returns the group ID of this group.
	*
	* @return the group ID of this group
	*/
	@Override
	public long getGroupId() {
		return _group.getGroupId();
	}

	/**
	* Returns the grp ID of this group.
	*
	* @return the grp ID of this group
	*/
	@Override
	public long getGrpId() {
		return _group.getGrpId();
	}

	/**
	* Returns the primary key of this group.
	*
	* @return the primary key of this group
	*/
	@Override
	public long getPrimaryKey() {
		return _group.getPrimaryKey();
	}

	/**
	* Returns the user ID of this group.
	*
	* @return the user ID of this group
	*/
	@Override
	public long getUserId() {
		return _group.getUserId();
	}

	@Override
	public void persist() {
		_group.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_group.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this group.
	*
	* @param companyId the company ID of this group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_group.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this group.
	*
	* @param createDate the create date of this group
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_group.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_group.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_group.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_group.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this group.
	*
	* @param groupId the group ID of this group
	*/
	@Override
	public void setGroupId(long groupId) {
		_group.setGroupId(groupId);
	}

	/**
	* Sets the grp ID of this group.
	*
	* @param grpId the grp ID of this group
	*/
	@Override
	public void setGrpId(long grpId) {
		_group.setGrpId(grpId);
	}

	/**
	* Sets the modified date of this group.
	*
	* @param modifiedDate the modified date of this group
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_group.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this group.
	*
	* @param name the name of this group
	*/
	@Override
	public void setName(java.lang.String name) {
		_group.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_group.setNew(n);
	}

	/**
	* Sets the primary key of this group.
	*
	* @param primaryKey the primary key of this group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_group.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_group.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this group.
	*
	* @param userId the user ID of this group
	*/
	@Override
	public void setUserId(long userId) {
		_group.setUserId(userId);
	}

	/**
	* Sets the user name of this group.
	*
	* @param userName the user name of this group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_group.setUserName(userName);
	}

	/**
	* Sets the user uuid of this group.
	*
	* @param userUuid the user uuid of this group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_group.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this group.
	*
	* @param uuid the uuid of this group
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_group.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroupWrapper)) {
			return false;
		}

		GroupWrapper groupWrapper = (GroupWrapper)obj;

		if (Objects.equals(_group, groupWrapper._group)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _group.getStagedModelType();
	}

	@Override
	public Group getWrappedModel() {
		return _group;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _group.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _group.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_group.resetOriginalValues();
	}

	private final Group _group;
}