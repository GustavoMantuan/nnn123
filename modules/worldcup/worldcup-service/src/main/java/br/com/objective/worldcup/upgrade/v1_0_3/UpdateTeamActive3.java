package br.com.objective.worldcup.upgrade.v1_0_3;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class UpdateTeamActive3 extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {

        if (hasColumn("WorldCup_Team", "active")) {
            runSQL("update WorldCup_Team set active = TRUE");
        }

    }

}
