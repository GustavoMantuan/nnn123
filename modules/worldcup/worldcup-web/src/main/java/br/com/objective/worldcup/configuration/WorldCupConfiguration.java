package br.com.objective.worldcup.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "br.com.objective.worldcup.configuration.WorldCupConfiguration",
            localization = "content/Language",
            name = "WorldCupConfiguration")
public interface WorldCupConfiguration {

    @Meta.AD(
            deflt = "Germany",
            required =  true
    )
    public String lastChampion();

    @Meta.AD(required = false)
    public int itemsPerPage();

}
