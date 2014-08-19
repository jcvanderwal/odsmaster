package com.wipro.wess.ods.asset;

import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.service.OmServiceConfigService;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

/**
 * OmSupplierAssetServiceMap generated by hbm2java
 */
@Named("OmSupplierAssetServiceMap")
@Bookmarkable
@Audited
@ObjectType("OmSupplierAssetServiceMap")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_supplier_asset_service_map", objectIdClass = SupplierAssetServiceMapPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_suplservicemap_by_user", language = "JPQL", value = "SELECT suplservicemap FROM com.wipro.wess.ods.asset.OmSupplierAssetServiceMap suplservicemap "
        + " JOIN suplservicemap.omSupplierAssetConfig suplasset"
        + " JOIN suplasset.omSite site WHERE EXISTS "
        + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site = site AND permission IN "
        + " (SELECT "
        + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
        + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) )") })
public class OmSupplierAssetServiceMap implements java.io.Serializable, InstanceCallbacks {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1381460377912901169L;

    private long saServiceMapId;

    private OmSupplierAssetConfig omSupplierAssetConfig;

    private OmServiceConfig omServiceConfig;
    
    private String configUser;

    public OmSupplierAssetServiceMap() {
    }

    public OmSupplierAssetServiceMap(long saServiceMapId, OmSupplierAssetConfig omSupplierAssetConfig) {
        this.saServiceMapId = saServiceMapId;
        this.omSupplierAssetConfig = omSupplierAssetConfig;
    }

    @Column(name = "sa_service_map_id", allowsNull = "false")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Hidden(where = Where.ANYWHERE)
    public long getSaServiceMapId() {
        return this.saServiceMapId;
    }

    public void setSaServiceMapId(long saServiceMapId) {
        this.saServiceMapId = saServiceMapId;
    }

    @Column(name = "sup_asset_uid", allowsNull = "false")
    @Title
    public OmSupplierAssetConfig getOmSupplierAssetConfig() {
        return this.omSupplierAssetConfig;
    }

    public void setOmSupplierAssetConfig(OmSupplierAssetConfig omSupplierAssetConfig) {
        this.omSupplierAssetConfig = omSupplierAssetConfig;
    }

    @Column(name = "service_uid", allowsNull = "false")
    @Title
    public OmServiceConfig getOmServiceConfig() {
        return omServiceConfig;
    }

    public void setOmServiceConfig(OmServiceConfig omServiceConfig) {
        this.omServiceConfig = omServiceConfig;
    }

    private OmSupplierAssetService supplierAssetService;

    public void injectOmSupplierAssetService(OmSupplierAssetService supplierAssetService) {
        this.supplierAssetService = supplierAssetService;
    }

    public List<OmSupplierAssetConfig> choicesOmSupplierAssetConfig() {
        return this.supplierAssetService.listAllSupplierAssets();
    }

    private OmServiceConfigService serviceConfigService;

    public void injectOmServiceConfigService(OmServiceConfigService serviceConfigService) {
        this.serviceConfigService = serviceConfigService;
    }

    public List<OmServiceConfig> choicesOmServiceConfig() {
        return this.serviceConfigService.listAllServiceConfigs();
    }
    
    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
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

}
