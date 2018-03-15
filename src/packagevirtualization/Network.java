package packagevirtualization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"status",
"router:external",
"availability_zone_hints",
"availability_zones",
"description",
"provider:physical_network",
"subnets",
"shared",
"name",
"created_at",
"tags",
"updated_at",
"provider:network_type",
"ipv6_address_scope",
"tenant_id",
"admin_state_up",
"ipv4_address_scope",
"port_security_enabled",
"mtu",
"id",
"provider:segmentation_id"
})
public class Network {

@JsonProperty("status")
private String status;
@JsonProperty("router:external")
private Boolean routerExternal;
@JsonProperty("availability_zone_hints")
private List<Object> availabilityZoneHints = new ArrayList<Object>();
@JsonProperty("availability_zones")
private List<Object> availabilityZones = new ArrayList<Object>();
@JsonProperty("description")
private String description;
@JsonProperty("provider:physical_network")
private Object providerPhysicalNetwork;
@JsonProperty("subnets")
private List<Object> subnets = new ArrayList<Object>();
@JsonProperty("shared")
private Boolean shared;
@JsonProperty("name")
private String name;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("tags")
private List<Object> tags = new ArrayList<Object>();
@JsonProperty("updated_at")
private String updatedAt;
@JsonProperty("provider:network_type")
private String providerNetworkType;
@JsonProperty("ipv6_address_scope")
private Object ipv6AddressScope;
@JsonProperty("tenant_id")
private String tenantId;
@JsonProperty("admin_state_up")
private Boolean adminStateUp;
@JsonProperty("ipv4_address_scope")
private Object ipv4AddressScope;
@JsonProperty("port_security_enabled")
private Boolean portSecurityEnabled;
@JsonProperty("mtu")
private Integer mtu;
@JsonProperty("id")
private String id;
@JsonProperty("provider:segmentation_id")
private Integer providerSegmentationId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The status
*/
@JsonProperty("status")
public String getStatus() {
return status;
}

/**
* 
* @param status
* The status
*/
@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

/**
* 
* @return
* The routerExternal
*/
@JsonProperty("router:external")
public Boolean getRouterExternal() {
return routerExternal;
}

/**
* 
* @param routerExternal
* The router:external
*/
@JsonProperty("router:external")
public void setRouterExternal(Boolean routerExternal) {
this.routerExternal = routerExternal;
}

/**
* 
* @return
* The availabilityZoneHints
*/
@JsonProperty("availability_zone_hints")
public List<Object> getAvailabilityZoneHints() {
return availabilityZoneHints;
}

/**
* 
* @param availabilityZoneHints
* The availability_zone_hints
*/
@JsonProperty("availability_zone_hints")
public void setAvailabilityZoneHints(List<Object> availabilityZoneHints) {
this.availabilityZoneHints = availabilityZoneHints;
}

/**
* 
* @return
* The availabilityZones
*/
@JsonProperty("availability_zones")
public List<Object> getAvailabilityZones() {
return availabilityZones;
}
@JsonProperty("id")
public String getId() {
return id;
}
}