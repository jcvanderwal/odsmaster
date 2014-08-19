package com.wipro.wess.ods.site;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Columns;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Mandatory;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.masterconfig.MSourcetypeConfigs;

/**
 * OmSiteSrefFormula generated by hbm2java
 */
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_site_sref_formula", objectIdClass = SiteSRefeFormulaPK.class, identityType = IdentityType.APPLICATION)
// @javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_OmSiteSrefFormula_by_pk", language = "JDOQL", value = "SELECT "
                + " siteRefForm FROM com.wipro.wess.ods.site.OmSiteSrefFormula siteRefForm  WHERE siteSrefFormulaId == :siteSrefFormulaId"),
        @javax.jdo.annotations.Query(name = "fetch_OmSiteSrefFormula_by_uk", language = "JDOQL", value = "SELECT "
                + " siteRefForm FROM com.wipro.wess.ods.site.OmSiteSrefFormula siteRefForm  WHERE omSite.orgId == :org && omSite == :site && MSourcetypeConfig == :sourceType"),
        @javax.jdo.annotations.Query(name = "fetch_siterefformulas_by_user", language = "JPQL", value = "SELECT siteref FROM com.wipro.wess.ods.site.OmSiteSrefFormula siteref "
                + " JOIN siteref.omSite site WHERE EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site = site AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) )") })
@Audited
@ObjectType("OmSiteSrefFormula")
@Bookmarkable
@Sequence(name = "site_sref_formula_id", datastoreSequence = "site_sref_formula_id", strategy = SequenceStrategy.CONTIGUOUS)
public class OmSiteSrefFormula implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -6392990529332816282L;

    private long siteSrefFormulaId;

    // private MOrganisation MOrganisation;

    private OmSite omSite;

    private MSourcetypeConfig MSourcetypeConfig;

    private String referenceUmF;

    private String referenceCmF;

    private String referenceOmF;

    private String masterF;

    private String insertedBy;

    private Date insertedTimeTs;

    private Long sourceId;

    private Date changeTs;

    private String configUser;

    public OmSiteSrefFormula() {
    }

    public OmSiteSrefFormula(long siteSrefFormulaId, /* MOrganisation MOrganisation, */OmSite omSite,
            MSourcetypeConfig MSourcetypeConfig, String insertedBy, Date insertedTimeTs, Date changeTs) {
        this.siteSrefFormulaId = siteSrefFormulaId;
        // this.MOrganisation = MOrganisation;
        this.omSite = omSite;
        this.MSourcetypeConfig = MSourcetypeConfig;
        this.insertedBy = insertedBy;
        this.insertedTimeTs = insertedTimeTs;
        this.changeTs = changeTs;
    }

    public OmSiteSrefFormula(long siteSrefFormulaId, /* MOrganisation MOrganisation, */OmSite omSite,
            MSourcetypeConfig MSourcetypeConfig, String referenceUmF, String referenceCmF, String referenceOmF,
            String masterF, String insertedBy, Date insertedTimeTs, Long sourceId, Date changeTs) {
        this.siteSrefFormulaId = siteSrefFormulaId;
        // this.MOrganisation = MOrganisation;
        this.omSite = omSite;
        this.MSourcetypeConfig = MSourcetypeConfig;
        this.referenceUmF = referenceUmF;
        this.referenceCmF = referenceCmF;
        this.referenceOmF = referenceOmF;
        this.masterF = masterF;
        this.insertedBy = insertedBy;
        this.insertedTimeTs = insertedTimeTs;
        this.sourceId = sourceId;
        this.changeTs = changeTs;
    }

    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Column(allowsNull = "false", name = "site_sref_formula_id")
    @Title
    @Hidden(where = Where.ANYWHERE)
    public long getSiteSrefFormulaId() {
        return this.siteSrefFormulaId;
    }

    public void setSiteSrefFormulaId(long siteSrefFormulaId) {
        this.siteSrefFormulaId = siteSrefFormulaId;
    }

    /*
     * @Column(allowsNull = "false", name = "org_id") public MOrganisation getMOrganisation() { return
     * this.MOrganisation; } public void setMOrganisation(MOrganisation MOrganisation) { this.MOrganisation =
     * MOrganisation; }
     */

    @Columns({ @Column(allowsNull = "false", name = "org_id"), @Column(allowsNull = "false", name = "site_id") })
    @Mandatory
    public OmSite getOmSite() {
        return this.omSite;
    }

    public void setOmSite(OmSite omSite) {
        this.omSite = omSite;
    }

    @Column(allowsNull = "false", name = "sourcetype_id")
    public MSourcetypeConfig getMSourcetypeConfig() {
        return this.MSourcetypeConfig;
    }

    public void setMSourcetypeConfig(MSourcetypeConfig MSourcetypeConfig) {
        this.MSourcetypeConfig = MSourcetypeConfig;
    }

    @Column(name = "reference_um_f")
    @Optional
    public String getReferenceUmF() {
        return this.referenceUmF;
    }

    public void setReferenceUmF(String referenceUmF) {
        this.referenceUmF = referenceUmF;
    }

    @Column(name = "reference_cm_f")
    @Optional
    public String getReferenceCmF() {
        return this.referenceCmF;
    }

    public void setReferenceCmF(String referenceCmF) {
        this.referenceCmF = referenceCmF;
    }

    @Column(name = "reference_om_f")
    @Optional
    public String getReferenceOmF() {
        return this.referenceOmF;
    }

    public void setReferenceOmF(String referenceOmF) {
        this.referenceOmF = referenceOmF;
    }

    @Column(name = "master_f")
    @Optional
    public String getMasterF() {
        return this.masterF;
    }

    public void setMasterF(String masterF) {
        this.masterF = masterF;
    }

    @Column(allowsNull = "false", name = "inserted_by")
    @Hidden(where = Where.ANYWHERE)
    public String getInsertedBy() {
        return this.insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    @Column(allowsNull = "false", name = "inserted_time_ts")
    @Hidden(where = Where.ANYWHERE)
    public Date getInsertedTimeTs() {
        return this.insertedTimeTs;
    }

    public void setInsertedTimeTs(Date insertedTimeTs) {
        this.insertedTimeTs = insertedTimeTs;
    }

    @Column(name = "source_id_")
    @Hidden(where = Where.ALL_TABLES)
    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Column(allowsNull = "false", name = "change_ts")
    @Hidden(where = Where.OBJECT_FORMS)
    public Date getChangeTs() {
        return this.changeTs;
    }

    public void setChangeTs(Date changeTs) {
        this.changeTs = changeTs;
    }

    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (siteSrefFormulaId ^ (siteSrefFormulaId >>> 32));
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
        OmSiteSrefFormula other = (OmSiteSrefFormula) obj;
        if (siteSrefFormulaId != other.siteSrefFormulaId)
            return false;
        return true;
    }

    private OmSiteService siteService;

    public void injectOmSiteService(OmSiteService siteService) {
        this.siteService = siteService;
    }

    public List<OmSite> choicesOmSite() {
        return this.siteService.listAllSites();
    }

    private MSourcetypeConfigs sourceTypeConfigService;

    public void injectMSourcetypeConfigs(MSourcetypeConfigs sourceTypeConfigService) {
        this.sourceTypeConfigService = sourceTypeConfigService;
    }

    public List<MSourcetypeConfig> choicesMSourcetypeConfig() {
        return this.sourceTypeConfigService.listAll();
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    public void jdoPostLoad() {
    }

    public void jdoPreClear() {
    }

    public void jdoPreStore() {
        this.setChangeTs(new Date());
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmSiteSrefFormula> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.siteService.listAllSiteRefFormula();

    }

}
