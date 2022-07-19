import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationBody {
    @JsonProperty("post code")
    public String postCode;
    public String country;
    @JsonProperty("country abbreviation")
    public String countryAbbreviation;
    public ArrayList<Place> places= new ArrayList<>();
    public static class Place{
        @JsonProperty("place name")
        public String placeName;
        public String longitude;
        public String state;
        @JsonProperty("state abbreviation")
        public String stateAbbreviation;
        public String latitude;
    }
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
