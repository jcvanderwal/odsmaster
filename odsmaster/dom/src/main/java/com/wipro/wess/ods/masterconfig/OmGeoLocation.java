package com.wipro.wess.ods.masterconfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Columns;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.site.OmSite;

// Generated Dec 19, 2013 5:56:26 PM by Hibernate Tools 3.2.2.GA

/**
 * OmGeoLocation generated by hbm2java
 */
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_geo_location", objectIdClass = OmGeoLocationPK.class, identityType = IdentityType.APPLICATION)
// @javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER,
// column = "version")
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_geolocations_by_user", language = "JPQL", value = "SELECT geolocation FROM com.wipro.wess.ods.masterconfig.OmGeoLocation geolocation "
                + " JOIN geolocation.orgId organization WHERE EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site.orgId = organization AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) "),
        @javax.jdo.annotations.Query(name = "fetch_geolocations_by_org_user", language = "JPQL", value = "SELECT geolocation FROM com.wipro.wess.ods.masterconfig.OmGeoLocation geolocation "
                + " JOIN geolocation.orgId organization WHERE orgId = :orgId AND EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site.orgId = organization AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ") })
@Audited
@ObjectType("OmGeoLocation")
@Bookmarkable
public class OmGeoLocation implements java.io.Serializable, InstanceCallbacks {

    /**
	 * 
	 */
    private static final long serialVersionUID = 9058800176219988612L;

    private String locationId;

    private MOrganisation orgId;

    private OmGeoLocation omGeoLocation;

    private String locationDetails;

    private String locationType;

    private Set<OmSite> sites = new HashSet<OmSite>();

    private DomainObjectContainer container;

    private String configUser;

    public OmGeoLocation() {
    }

    public OmGeoLocation(String locationId, MOrganisation orgId) {
        super();
        this.locationId = locationId;
        this.orgId = orgId;
    }

    public OmGeoLocation(OmGeoLocation omGeoLocation) {
        this.omGeoLocation = omGeoLocation;
    }

    @Persistent(primaryKey = "true", dependent = "false")
    @Column(allowsNull = "false", name = "location_id")
    @Title
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Persistent(primaryKey = "true", dependent = "false")
    @Column(allowsNull = "false", name = "org_id")
    @Title
    public MOrganisation getOrgId() {
        return orgId;
    }

    public void setOrgId(MOrganisation orgId) {
        this.orgId = orgId;
    }

    @Columns(value = { @Column(name = "parent_location_id"), @Column(name = "parent_geo_loc_org_id") })
    @Optional
    public OmGeoLocation getOmGeoLocation() {
        return this.omGeoLocation;
    }

    public void setOmGeoLocation(OmGeoLocation omGeoLocation) {
        this.omGeoLocation = omGeoLocation;
    }

    @Column(name = "location_details")
    @Optional
    public String getLocationDetails() {
        return this.locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    @Column(name = "location_type")
    @Optional
    public String getLocationType() {
        return this.locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @Persistent(mappedBy = "omGeoLocation", dependentElement = "false")
    public Set<OmSite> getSites() {
        return sites;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
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
        OmGeoLocation other = (OmGeoLocation) obj;
        if (locationId == null) {
            if (other.locationId != null)
                return false;
        } else if (!locationId.equals(other.locationId))
            return false;
        if (orgId == null) {
            if (other.orgId != null)
                return false;
        } else if (!orgId.equals(other.orgId))
            return false;
        return true;
    }

    public void setSites(Set<OmSite> sites) {
        this.sites = sites;
    }

    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
    }

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    public List<OmGeoLocation> choicesOmGeoLocation() {
        List<OmGeoLocation> parentLocations = this.container.allMatches(new QueryDefault<OmGeoLocation>(
                OmGeoLocation.class, "fetch_geolocations_by_user", "userName", this.container.getUser().getName()));
        if (parentLocations != null) {
            parentLocations.remove(this);
        }
        return parentLocations;
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
    
    private MasterConfigurationService masterConfigurationService;

    public void injectMasterConfigurationService(MasterConfigurationService masterConfigurationService) {
        this.masterConfigurationService = masterConfigurationService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmGeoLocation> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.masterConfigurationService.listAllGeolocations();

    }

}
