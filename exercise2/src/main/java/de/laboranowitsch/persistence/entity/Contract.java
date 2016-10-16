package de.laboranowitsch.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Contract {@link javax.persistence.Entity} class.
 */
@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_from")
    private LocalDate validTo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
