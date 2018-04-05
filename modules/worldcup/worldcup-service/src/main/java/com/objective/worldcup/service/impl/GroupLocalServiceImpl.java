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

package com.objective.worldcup.service.impl;

import com.objective.worldcup.model.Group;
import com.objective.worldcup.service.base.GroupLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.objective.worldcup.service.GroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupLocalServiceBaseImpl
 * @see com.objective.worldcup.service.GroupLocalServiceUtil
 */
public class GroupLocalServiceImpl extends GroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.objective.worldcup.service.GroupLocalServiceUtil} to access the group local service.
	 */

    public Group addGroupWithoutId(Group group) {
        long resourcePrimKey = counterLocalService.increment();

        group.setGrpId(resourcePrimKey);

        return addGroup(group);
    }

    public List<Group> getAllGroups() {
        return getGroups(0, getGroupsCount());
    }

    public Group updateGroup(Group group) {
        return groupLocalService.updateGroup(group);
    }

}