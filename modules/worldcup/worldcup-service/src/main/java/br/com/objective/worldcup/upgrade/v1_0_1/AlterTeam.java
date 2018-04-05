package br.com.objective.worldcup.upgrade.v1_0_1;

import br.com.objective.worldcup.model.impl.TeamModelImpl;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class AlterTeam extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {

        alter(TeamModelImpl.class, new AlterTableAddColumn("active BOOLEAN"));

    }

}
