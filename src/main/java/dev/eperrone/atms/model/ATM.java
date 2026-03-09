package dev.eperrone.atms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * ATM
 * Entidad JPA que mapea la tabla 'atms' en la base de datos
 */
@Data
@Entity
@Table(name = "atms")  // Nombre exacto de tu tabla en Aiven
public class ATM {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String bank;

  @Column(nullable = false, length = 255)
  private String address;

  @Column(nullable = false)
  private Double latitude;

  @Column(nullable = false)
  private Double longitude;

  private Long localityId;

  @Column(length = 20)
  private String postalCode;

  @Column(columnDefinition = "boolean default false")
  private Boolean has24h = false;

  @Column(columnDefinition = "boolean default false")
  private Boolean hasDeposit = false;

  @Column(nullable = false, length = 20)
  private String status = "active";

  @Column(nullable = false, updatable = false)
  private OffsetDateTime createdAt;

  private OffsetDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = OffsetDateTime.now();
    updatedAt = OffsetDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = OffsetDateTime.now();
  }
}