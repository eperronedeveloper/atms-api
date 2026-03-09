package dev.eperrone.atms.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.eperrone.atms.model.ATM;
import dev.eperrone.atms.model.Pagination;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SearchATMs200Response
 */

@Setter
@JsonTypeName("searchATMs_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public class SearchATMs200Response {

  private Pagination pagination;

  @Valid
  private List<@Valid ATM> atms = new ArrayList<>();

  public SearchATMs200Response pagination(Pagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
   */
  @Valid 
  @Schema(name = "pagination", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pagination")
  public Pagination getPagination() {
    return pagination;
  }

    public SearchATMs200Response atms(List<@Valid ATM> atms) {
    this.atms = atms;
    return this;
  }

  public SearchATMs200Response addAtmsItem(ATM atmsItem) {
    if (this.atms == null) {
      this.atms = new ArrayList<>();
    }
    this.atms.add(atmsItem);
    return this;
  }

  /**
   * Get atms
   * @return atms
   */
  @Valid 
  @Schema(name = "atms", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("atms")
  public List<@Valid ATM> getAtms() {
    return atms;
  }

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchATMs200Response searchATMs200Response = (SearchATMs200Response) o;
    return Objects.equals(this.pagination, searchATMs200Response.pagination) &&
        Objects.equals(this.atms, searchATMs200Response.atms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, atms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchATMs200Response {\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    atms: ").append(toIndentedString(atms)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

