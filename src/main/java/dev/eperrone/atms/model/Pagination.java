package dev.eperrone.atms.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Pagination
 */

@Setter
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public class Pagination {

  private Integer totalItems;

  private Integer offset;

  private Integer limit;

  public Pagination() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Pagination(Integer totalItems, Integer offset, Integer limit) {
    this.totalItems = totalItems;
    this.offset = offset;
    this.limit = limit;
  }

  public Pagination totalItems(Integer totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  /**
   * Cantidad total de registros que cumplen el filtro
   * @return totalItems
   */
  @NotNull 
  @Schema(name = "totalItems", example = "150", description = "Cantidad total de registros que cumplen el filtro", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalItems")
  public Integer getTotalItems() {
    return totalItems;
  }

    public Pagination offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
   */
  @NotNull 
  @Schema(name = "offset", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public Integer getOffset() {
    return offset;
  }

    public Pagination limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * @return limit
   */
  @NotNull 
  @Schema(name = "limit", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagination pagination = (Pagination) o;
    return Objects.equals(this.totalItems, pagination.totalItems) &&
        Objects.equals(this.offset, pagination.offset) &&
        Objects.equals(this.limit, pagination.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalItems, offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pagination {\n");
    sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

