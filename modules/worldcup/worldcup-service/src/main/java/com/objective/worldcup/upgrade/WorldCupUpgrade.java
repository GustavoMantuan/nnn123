package com.objective.worldcup.upgrade;

import com.objective.worldcup.upgrade.v1_0_1.AlterTeam;
import com.objective.worldcup.upgrade.v1_0_2.UpdateTeamActive;
import com.objective.worldcup.upgrade.v1_0_3.UpdateTeamActive3;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class WorldCupUpgrade implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        registry.register("com.objective.worldcup.service", "1.0.0", "1.0.1",
                new AlterTeam());

        registry.register("com.objective.worldcup.service", "1.0.1", "1.0.2",
                new UpdateTeamActive());

        registry.register("com.objective.worldcup.service", "1.0.2", "1.0.3",
                new UpdateTeamActive3());

    }

}
