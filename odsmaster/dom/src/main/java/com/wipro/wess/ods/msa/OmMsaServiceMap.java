package com.wipro.wess.ods.msa;

import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.service.OmServiceConfigService;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

/**
 * OmMsaServiceMap generated by hbm2java
 */
@Named("MsaServiceMap")
@Bookmarkable
@Audited
@ObjectType("OmMsaServiceMap")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_msa_service_map", objectIdClass = OmMsaServiceMapPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_OmMsaServiceMap_by_msa_service_map", language = "JDOQL", value = "SELECT "
                + " OmMsaServiceMap FROM com.wipro.wess.ods.msa.OmMsaServiceMap OmMsaServiceMap WHERE serviceUid == :serviceUid && omMsaConfig == :omMsaConfig "),
        @javax.jdo.annotations.Query(name = "fetch_OmMsaServiceMap_by_pk", language = "JDOQL", value = "SELECT "
                + " OmMsaServiceMap FROM com.wipro.wess.ods.msa.OmMsaServiceMap OmMsaServiceMap WHERE msaServiceMapId == :msaServiceMapId "),
        @javax.jdo.annotations.Query(name = "fetch_msaservicemap_by_user", language = "JPQL", value = "SELECT msaservice FROM com.wipro.wess.ods.msa.OmMsaServiceMap msaservice "
                + " WHERE msaservice.omMsaConfig IN ("
                + " SELECT msasitemap.msaUid FROM com.wipro.wess.ods.site.OmMsaSiteMap msasitemap"
                + " JOIN msasitemap.omSite site WHERE EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site = site AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ) ") })
public class OmMsaServiceMap implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -295054377765532852L;

    private long msaServiceMapId;

    private OmMsaConfig omMsaConfig;

    private OmServiceConfig serviceUid;

    private MOrganisation orgId;
    
    private String configUser;

    public OmMsaServiceMap() {
    }

    public OmMsaServiceMap(long msaServiceMapId, OmMsaConfig omMsaConfig, OmServiceConfig serviceUid) {
        this.msaServiceMapId = msaServiceMapId;
        this.omMsaConfig = omMsaConfig;
        this.serviceUid = serviceUid;
    }

    @Column(allowsNull = "false", name = "msa_service_map_id")
    @Title
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Hidden(where = Where.ANYWHERE)
    public long getMsaServiceMapId() {
        return this.msaServiceMapId;
    }

    public void setMsaServiceMapId(long msaServiceMapId) {
        this.msaServiceMapId = msaServiceMapId;
    }

    @Column(allowsNull = "false", name = "msa_uid")
    public OmMsaConfig getOmMsaConfig() {
        return this.omMsaConfig;
    }

    public void setOmMsaConfig(OmMsaConfig omMsaConfig) {
        this.omMsaConfig = omMsaConfig;
    }

    @Column(allowsNull = "false", name = "service_uid")
    public OmServiceConfig getServiceUid() {
        return this.serviceUid;
    }

    public void setServiceUid(OmServiceConfig serviceUid) {
        this.serviceUid = serviceUid;
    }

    @Column(allowsNull = "false", name = "org_id")
    @Hidden(where = Where.ANYWHERE)
    public MOrganisation getOrgId() {
        return orgId;
    }

    public void setOrgId(MOrganisation orgId) {
        this.orgId = orgId;
    }
    
    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
    }
    
    private OmMsaConfigService msaConfigService;
    public void injectOmMsaConfigService(OmMsaConfigService msaConfigService) {
        this.msaConfigService = msaConfigService;
    }
    
    public List<OmMsaConfig> choicesOmMsaConfig() {
        return this.msaConfigService.listAllMsaConfigs();
    }
    
    private OmServiceConfigService omServiceConfigService;
    
    public void injectOmServiceConfigService(OmServiceConfigService omServiceConfigService){
     this.omServiceConfigService = omServiceConfigService;   
    }
    
    public List<OmServiceConfig> choicesServiceUid() {
        return this.omServiceConfigService.listAllServiceConfigs();
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
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }
    


    @Bulk
    @CssClass("x-caution")
    public List<OmMsaServiceMap> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.msaConfigService.listAllMsaServiceMap();

    }

}
