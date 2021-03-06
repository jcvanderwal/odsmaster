package com.wipro.wess.ods.msa;

import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotContributed;
import org.apache.isis.applib.annotation.NotInServiceMenu;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.organisation.OrganisationService;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

/**
 * OmModeOfOperationConfig generated by hbm2java
 */
@Named("ModeOfOpConfig")
@Bookmarkable
@Audited
@ObjectType("OmModeOfOperationConfig")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_mode_of_operation_config", objectIdClass = OmModeOfOperationConfigPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_OmModeOfOperationConfig_by_pk", language = "JDOQL", value = "SELECT "
                + " OmModeOfOperationConfig FROM com.wipro.wess.ods.msa.OmModeOfOperationConfig OmModeOfOperationConfig "
                + " WHERE modeName == :modeName && organisation == :organisation"),
        @javax.jdo.annotations.Query(name = "fetch_oprmodeconfigs_by_user", language = "JPQL", value = "SELECT config FROM com.wipro.wess.ods.msa.OmModeOfOperationConfig config "
                + " JOIN config.organisation organization WHERE EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site.orgId = organization AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ") })
public class OmModeOfOperationConfig implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = 7627246417181356909L;

    // private OmModeOfOperationConfigPK id;

    private MOrganisation organisation;

    private String modeName;

    private String modeDescription;

    private Long sourceId;

    private String configUser;

    // private Set<OmMsaModeopDef> omMsaModeopDefs = new HashSet<OmMsaModeopDef>(0);

    public OmModeOfOperationConfig() {
    }

    public OmModeOfOperationConfig(MOrganisation organisation, String modeDescription) {
        this.organisation = organisation;
        this.modeDescription = modeDescription;
    }

    public OmModeOfOperationConfig(MOrganisation organisation, String modeDescription, Long sourceId) {
        this.organisation = organisation;
        this.modeDescription = modeDescription;
        this.sourceId = sourceId;
        // this.omMsaModeopDefs = omMsaModeopDefs;
    }

    @Persistent(primaryKey = "true", dependent = "false")
    @Column(allowsNull = "false", name = "org_id")
    @Title
    public MOrganisation getOrganisation() {
        return this.organisation;
    }

    public void setOrganisation(MOrganisation organisation) {
        this.organisation = organisation;
    }

    @Persistent(primaryKey = "true")
    @Column(allowsNull = "false", name = "mode_name")
    @Title
    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    @Column(allowsNull = "false", name = "mode_description")
    public String getModeDescription() {
        return this.modeDescription;
    }

    public void setModeDescription(String modeDescription) {
        this.modeDescription = modeDescription;
    }

    @Column(name = "source_id")
    @Hidden(where = Where.ALL_TABLES)
    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
    }

    /*
     * @Persistent(mappedBy = "omModeOfOperationConfig", dependentElement = "true") public Set<OmMsaModeopDef>
     * getOmMsaModeopDefs() { return this.omMsaModeopDefs; } public void setOmMsaModeopDefs(Set<OmMsaModeopDef>
     * omMsaModeopDefs) { this.omMsaModeopDefs = omMsaModeopDefs; }
     */

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    @NotInServiceMenu
    @NotContributed
    @Hidden
    public void persist(String modeName, MOrganisation organisation, String modeDescription) {
        this.setModeName(modeName);
        this.setModeDescription(modeDescription);
        this.setOrganisation(organisation);
        this.container.persistIfNotAlready(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modeName == null) ? 0 : modeName.hashCode());
        result = prime * result + ((organisation == null) ? 0 : organisation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OmModeOfOperationConfig other = (OmModeOfOperationConfig) obj;
        if (modeName == null) {
            if (other.modeName != null)
                return false;
        } else if (!modeName.equals(other.modeName))
            return false;
        if (organisation == null) {
            if (other.organisation != null)
                return false;
        } else if (!organisation.equals(other.organisation))
            return false;
        return true;
    }

    private OrganisationService orgService;

    public void injectOrganisationService(OrganisationService orgService) {
        this.orgService = orgService;
    }

    public List<MOrganisation> choicesOrganisation() {
        return this.orgService.listAllOrganisations();
    }

    public void jdoPostLoad() {
    }

    public void jdoPreClear() {
    }

    public void jdoPreStore() {
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }

    private OmModeOfOperationConfigService modeOfOperationConfigService;

    public void injectOmModeOfOperationConfigService(OmModeOfOperationConfigService modeOfOperationConfigService) {
        this.modeOfOperationConfigService = modeOfOperationConfigService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmModeOfOperationConfig> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.modeOfOperationConfigService.listAllModeOprConfigs();

    }
}
