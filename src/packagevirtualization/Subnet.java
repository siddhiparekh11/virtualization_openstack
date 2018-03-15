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
"description",
"enable_dhcp",
"network_id",
"tenant_id",
"created_at",
"dns_nameservers",
"updated_at",
"gateway_ip",
"ipv6_ra_mode",
"allocation_pools",
"host_routes",
"ip_version",
"ipv6_address_mode",
"cidr",
"id",
"subnetpool_id",
"name"
})
public class Subnet {

@JsonProperty("description")
private String description;
@JsonProperty("enable_dhcp")
private Boolean enableDhcp;
@JsonProperty("network_id")
private String networkId;
@JsonProperty("tenant_id")
private String tenantId;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("dns_nameservers")
private List<Object> dnsNameservers = null;
@JsonProperty("updated_at")
private String updatedAt;
@JsonProperty("gateway_ip")
private String gatewayIp;
@JsonProperty("ipv6_ra_mode")
private Object ipv6RaMode;
@JsonProperty("allocation_pools")
private List<AllocationPool> allocationPools = null;
@JsonProperty("host_routes")
private List<Object> hostRoutes = null;
@JsonProperty("ip_version")
private Integer ipVersion;
@JsonProperty("ipv6_address_mode")
private Object ipv6AddressMode;
@JsonProperty("cidr")
private String cidr;
@JsonProperty("id")
private String id;
@JsonProperty("subnetpool_id")
private Object subnetpoolId;
@JsonProperty("name")
private String name;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
* The enableDhcp
*/
@JsonProperty("enable_dhcp")
public Boolean getEnableDhcp() {
return enableDhcp;
}

/**
* 
* @param enableDhcp
* The enable_dhcp
*/
@JsonProperty("enable_dhcp")
public void setEnableDhcp(Boolean enableDhcp) {
this.enableDhcp = enableDhcp;
}

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
* The createdAt
*/
@JsonProperty("created_at")
public String getCreatedAt() {
return createdAt;
}

/**
* 
* @param createdAt
* The created_at
*/
@JsonProperty("created_at")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

/**
* 
* @return
* The dnsNameservers
*/
@JsonProperty("dns_nameservers")
public List<Object> getDnsNameservers() {
return dnsNameservers;
}

/**
* 
* @param dnsNameservers
* The dns_nameservers
*/
@JsonProperty("dns_nameservers")
public void setDnsNameservers(List<Object> dnsNameservers) {
this.dnsNameservers = dnsNameservers;
}

/**
* 
* @return
* The updatedAt
*/
@JsonProperty("updated_at")
public String getUpdatedAt() {
return updatedAt;
}

/**
* 
* @param updatedAt
* The updated_at
*/
@JsonProperty("updated_at")
public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

/**
* 
* @return
* The gatewayIp
*/
@JsonProperty("gateway_ip")
public String getGatewayIp() {
return gatewayIp;
}

/**
* 
* @param gatewayIp
* The gateway_ip
*/
@JsonProperty("gateway_ip")
public void setGatewayIp(String gatewayIp) {
this.gatewayIp = gatewayIp;
}

/**
* 
* @return
* The ipv6RaMode
*/
@JsonProperty("ipv6_ra_mode")
public Object getIpv6RaMode() {
return ipv6RaMode;
}

/**
* 
* @param ipv6RaMode
* The ipv6_ra_mode
*/
@JsonProperty("ipv6_ra_mode")
public void setIpv6RaMode(Object ipv6RaMode) {
this.ipv6RaMode = ipv6RaMode;
}

/**
* 
* @return
* The allocationPools
*/
@JsonProperty("allocation_pools")
public List<AllocationPool> getAllocationPools() {
return allocationPools;
}

/**
* 
* @param allocationPools
* The allocation_pools
*/
@JsonProperty("allocation_pools")
public void setAllocationPools(List<AllocationPool> allocationPools) {
this.allocationPools = allocationPools;
}

/**
* 
* @return
* The hostRoutes
*/
@JsonProperty("host_routes")
public List<Object> getHostRoutes() {
return hostRoutes;
}

/**
* 
* @param hostRoutes
* The host_routes
*/
@JsonProperty("host_routes")
public void setHostRoutes(List<Object> hostRoutes) {
this.hostRoutes = hostRoutes;
}

/**
* 
* @return
* The ipVersion
*/
@JsonProperty("ip_version")
public Integer getIpVersion() {
return ipVersion;
}

/**
* 
* @param ipVersion
* The ip_version
*/
@JsonProperty("ip_version")
public void setIpVersion(Integer ipVersion) {
this.ipVersion = ipVersion;
}

/**
* 
* @return
* The ipv6AddressMode
*/
@JsonProperty("ipv6_address_mode")
public Object getIpv6AddressMode() {
return ipv6AddressMode;
}

/**
* 
* @param ipv6AddressMode
* The ipv6_address_mode
*/
@JsonProperty("ipv6_address_mode")
public void setIpv6AddressMode(Object ipv6AddressMode) {
this.ipv6AddressMode = ipv6AddressMode;
}

/**
* 
* @return
* The cidr
*/
@JsonProperty("cidr")
public String getCidr() {
return cidr;
}

/**
* 
* @param cidr
* The cidr
*/
@JsonProperty("cidr")
public void setCidr(String cidr) {
this.cidr = cidr;
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
* The subnetpoolId
*/
@JsonProperty("subnetpool_id")
public Object getSubnetpoolId() {
return subnetpoolId;
}

/**
* 
* @param subnetpoolId
* The subnetpool_id
*/
@JsonProperty("subnetpool_id")
public void setSubnetpoolId(Object subnetpoolId) {
this.subnetpoolId = subnetpoolId;
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
