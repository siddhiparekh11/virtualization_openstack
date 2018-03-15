package packagevirtualization;



import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"start",
"end"
})
public class AllocationPool {

@JsonProperty("start")
private String start;
@JsonProperty("end")
private String end;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The start
*/
@JsonProperty("start")
public String getStart() {
return start;
}

/**
* 
* @param start
* The start
*/
@JsonProperty("start")
public void setStart(String start) {
this.start = start;
}

/**
* 
* @return
* The end
*/
@JsonProperty("end")
public String getEnd() {
return end;
}

/**
* 
* @param end
* The end
*/
@JsonProperty("end")
public void setEnd(String end) {
this.end = end;
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