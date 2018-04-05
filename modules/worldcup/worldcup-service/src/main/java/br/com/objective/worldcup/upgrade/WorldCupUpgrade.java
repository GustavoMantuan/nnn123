package br.com.objective.worldcup.upgrade;

import br.com.objective.worldcup.upgrade.v1_0_1.AlterTeam;
import br.com.objective.worldcup.upgrade.v1_0_2.UpdateTeamActive;
import br.com.objective.worldcup.upgrade.v1_0_3.UpdateTeamActive3;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class WorldCupUpgrade implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        registry.register("br.com.objective.worldcup.service", "1.0.0", "1.0.1",
                new AlterTeam());

        registry.register("br.com.objective.worldcup.service", "1.0.1", "1.0.2",
                new UpdateTeamActive());

        registry.register("br.com.objective.worldcup.service", "1.0.2", "1.0.3",
                new UpdateTeamActive3());

    }

}
