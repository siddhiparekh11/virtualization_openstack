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
"network_id",
"tenant_id",
"subnet_id",
"subnet_ids",
"port_id",
"id"
})
public class Example3 {

@JsonProperty("network_id")
private String networkId;
@JsonProperty("tenant_id")
private String tenantId;
@JsonProperty("subnet_id")
private String subnetId;
@JsonProperty("subnet_ids")
private List<String> subnetIds = null;
@JsonProperty("port_id")
private String portId;
@JsonProperty("id")
private String id;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The networkId
*/
@JsonProperty("network_id")
public String getNetworkId() {
return networkId;
}

/**
* 
* @param networkId
* The network_id
*/
@JsonProperty("network_id")
public void setNetworkId(String networkId) {
this.networkId = networkId;
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
* The subnetId
*/
@JsonProperty("subnet_id")
public String getSubnetId() {
return subnetId;
}

/**
* 
* @param subnetId
* The subnet_id
*/
@JsonProperty("subnet_id")
public void setSubnetId(String subnetId) {
this.subnetId = subnetId;
}

/**
* 
* @return
* The subnetIds
*/
@JsonProperty("subnet_ids")
public List<String> getSubnetIds() {
return subnetIds;
}

/**
* 
* @param subnetIds
* The subnet_ids
*/
@JsonProperty("subnet_ids")
public void setSubnetIds(List<String> subnetIds) {
this.subnetIds = subnetIds;
}

/**
* 
* @return
* The portId
*/
@JsonProperty("port_id")
public String getPortId() {
return portId;
}

/**
* 
* @param portId
* The port_id
*/
@JsonProperty("port_id")
public void setPortId(String portId) {
this.portId = portId;
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

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}
}

