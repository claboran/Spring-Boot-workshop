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

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        return id != null ? id.equals(contract.id) : contract.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contract{");
        sb.append("id=").append(id);
        sb.append(", validFrom=").append(validFrom);
        sb.append(", validTo=").append(validTo);
        sb.append('}');
        return sb.toString();
    }

    public static ContractBuilder builder() {
        return new ContractBuilder();
    }

    public static final class ContractBuilder {
        private Long id;
        private LocalDate validFrom;
        private LocalDate validTo;
        private Customer customer;

        private ContractBuilder() {
        }


        public ContractBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ContractBuilder withValidFrom(LocalDate validFrom) {
            this.validFrom = validFrom;
            return this;
        }

        public ContractBuilder withValidTo(LocalDate validTo) {
            this.validTo = validTo;
            return this;
        }

        public ContractBuilder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Contract build() {
            Contract contract = new Contract();
            contract.setId(id);
            contract.setValidFrom(validFrom);
            contract.setValidTo(validTo);
            contract.setCustomer(customer);
            return contract;
        }
    }
}
