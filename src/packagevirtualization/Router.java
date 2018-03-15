package packagevirtualization;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"status",
"external_gateway_info",
"availability_zone_hints",
"availability_zones",
"description",
"admin_state_up",
"tenant_id",
"distributed",
"routes",
"ha",
"id",
"name"
})
public class Router {

@JsonProperty("status")
private String status;
@JsonProperty("external_gateway_info")
private Object externalGatewayInfo;
@JsonProperty("availability_zone_hints")
private List<Object> availabilityZoneHints = null;
@JsonProperty("availability_zones")
private List<Object> availabilityZones = null;
@JsonProperty("description")
private String description;
@JsonProperty("admin_state_up")
private Boolean adminStateUp;
@JsonProperty("tenant_id")
private String tenantId;
@JsonProperty("distributed")
private Boolean distributed;
@JsonProperty("routes")
private List<Object> routes = null;
@JsonProperty("ha")
private Boolean ha;
@JsonProperty("id")
private String id;
@JsonProperty("name")
private String name;
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
* The externalGatewayInfo
*/
@JsonProperty("external_gateway_info")
public Object getExternalGatewayInfo() {
return externalGatewayInfo;
}

/**
* 
* @param externalGatewayInfo
* The external_gateway_info
*/
@JsonProperty("external_gateway_info")
public void setExternalGatewayInfo(Object externalGatewayInfo) {
this.externalGatewayInfo = externalGatewayInfo;
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

/**
* 
* @param availabilityZones
* The availability_zones
*/
@JsonProperty("availability_zones")
public void setAvailabilityZones(List<Object> availabilityZones) {
this.availabilityZones = availabilityZones;
}

/**
* 
* @return
* The description
*/
@JsonProperty("description")
public String getDescription() {
return description;
}

/**
* 
* @param description
* The description
*/
@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

/**
* 
* @return
* The adminStateUp
*/
@JsonProperty("admin_state_up")
public Boolean getAdminStateUp() {
return adminStateUp;
}

/**
* 
* @param adminStateUp
* The admin_state_up
*/
@JsonProperty("admin_state_up")
public void setAdminStateUp(Boolean adminStateUp) {
this.adminStateUp = adminStateUp;
}

/**
* 
* @return
* The tenantId
*/
@JsonProperty("tenant_id")
public String getTenantId() {
return tenantId;
}

/**
* 
* @param tenantId
* The tenant_id
*/
@JsonProperty("tenant_id")
public void setTenantId(String tenantId) {
this.tenantId = tenantId;
}

/**
* 
* @return
* The distributed
*/
@JsonProperty("distributed")
public Boolean getDistributed() {
return distributed;
}

/**
* 
* @param distributed
* The distributed
*/
@JsonProperty("distributed")
public void setDistributed(Boolean distributed) {
this.distributed = distributed;
}

/**
* 
* @return
* The routes
*/
@JsonProperty("routes")
public List<Object> getRoutes() {
return routes;
}

/**
* 
* @param routes
* The routes
*/
@JsonProperty("routes")
public void setRoutes(List<Object> routes) {
this.routes = routes;
}

/**
* 
* @return
* The ha
*/
@JsonProperty("ha")
public Boolean getHa() {
return ha;
}

/**
* 
* @param ha
* The ha
*/
@JsonProperty("ha")
public void setHa(Boolean ha) {
this.ha = ha;
}

/**
* 
* @return
* The id
*/
@JsonProperty("id")
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

/**
* 
* @return
* The name
*/
@JsonProperty("name")
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}