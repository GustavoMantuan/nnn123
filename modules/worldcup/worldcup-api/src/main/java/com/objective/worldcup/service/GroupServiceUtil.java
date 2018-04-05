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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Group. This utility wraps
 * {@link com.objective.worldcup.service.impl.GroupServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GroupService
 * @see com.objective.worldcup.service.base.GroupServiceBaseImpl
 * @see com.objective.worldcup.service.impl.GroupServiceImpl
 * @generated
 */
@ProviderType
public class GroupServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.objective.worldcup.service.impl.GroupServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.objective.worldcup.model.Group addGroupWithoutId(
		com.objective.worldcup.model.Group group) {
		return getService().addGroupWithoutId(group);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String helloWorld(java.lang.String worldName) {
		return getService().helloWorld(worldName);
	}

	public static java.util.List<com.objective.worldcup.model.Group> getAllGroups() {
		return getService().getAllGroups();
	}

	public static GroupService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroupService, GroupService> _serviceTracker = ServiceTrackerFactory.open(GroupService.class);
}