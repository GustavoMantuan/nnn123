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

package com.objective.worldcup.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupService}.
 *
 * @author Brian Wing Shun Chan
 * @see GroupService
 * @generated
 */
@ProviderType
public class GroupServiceWrapper implements GroupService,
	ServiceWrapper<GroupService> {
	public GroupServiceWrapper(GroupService groupService) {
		_groupService = groupService;
	}

	@Override
	public com.objective.worldcup.model.Group addGroupWithoutId(
		com.objective.worldcup.model.Group group) {
		return _groupService.addGroupWithoutId(group);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _groupService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String helloWorld(java.lang.String worldName) {
		return _groupService.helloWorld(worldName);
	}

	@Override
	public java.util.List<com.objective.worldcup.model.Group> getAllGroups() {
		return _groupService.getAllGroups();
	}

	@Override
	public GroupService getWrappedService() {
		return _groupService;
	}

	@Override
	public void setWrappedService(GroupService groupService) {
		_groupService = groupService;
	}

	private GroupService _groupService;
}