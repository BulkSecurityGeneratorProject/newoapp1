package io.github.jhipster.application.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import io.github.jhipster.application.domain.enumeration.TipoPersonad;

import io.github.jhipster.application.domain.enumeration.PeriodicidadFacturaciond;

/**
 * A Facturacion.
 */
@Entity
@Table(name = "facturacion")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Facturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "titular_factura")
    private String titularFactura;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_persona")
    private TipoPersonad tipoPersona;

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicidad_facturacion")
    private PeriodicidadFacturaciond periodicidadFacturacion;

    @Column(name = "maximo_monto")
    private Integer maximoMonto;

    @OneToOne
    @JoinColumn(unique = true)
    private Empresa empresa;

    @OneToOne
    @JoinColumn(unique = true)
    private CuentaAsociada cuentaAsociada;

    @OneToMany(mappedBy = "facturacion")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RegistroCompra> registroCompras = new HashSet<>();
    @OneToOne(mappedBy = "facturacion")
    @JsonIgnore
    private EquipoEmpresas equipoEmpresas;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitularFactura() {
        return titularFactura;
    }

    public Facturacion titularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
        return this;
    }

    public void setTitularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
    }

    public TipoPersonad getTipoPersona() {
        return tipoPersona;
    }

    public Facturacion tipoPersona(TipoPersonad tipoPersona) {
        this.tipoPersona = tipoPersona;
        return this;
    }

    public void setTipoPersona(TipoPersonad tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public PeriodicidadFacturaciond getPeriodicidadFacturacion() {
        return periodicidadFacturacion;
    }

    public Facturacion periodicidadFacturacion(PeriodicidadFacturaciond periodicidadFacturacion) {
        this.periodicidadFacturacion = periodicidadFacturacion;
        return this;
    }

    public void setPeriodicidadFacturacion(PeriodicidadFacturaciond periodicidadFacturacion) {
        this.periodicidadFacturacion = periodicidadFacturacion;
    }

    public Integer getMaximoMonto() {
        return maximoMonto;
    }

    public Facturacion maximoMonto(Integer maximoMonto) {
        this.maximoMonto = maximoMonto;
        return this;
    }

    public void setMaximoMonto(Integer maximoMonto) {
        this.maximoMonto = maximoMonto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Facturacion empresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public CuentaAsociada getCuentaAsociada() {
        return cuentaAsociada;
    }

    public Facturacion cuentaAsociada(CuentaAsociada cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
        return this;
    }

    public void setCuentaAsociada(CuentaAsociada cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public Set<RegistroCompra> getRegistroCompras() {
        return registroCompras;
    }

    public Facturacion registroCompras(Set<RegistroCompra> registroCompras) {
        this.registroCompras = registroCompras;
        return this;
    }

    public Facturacion addRegistroCompra(RegistroCompra registroCompra) {
        this.registroCompras.add(registroCompra);
        registroCompra.setFacturacion(this);
        return this;
    }

    public Facturacion removeRegistroCompra(RegistroCompra registroCompra) {
        this.registroCompras.remove(registroCompra);
        registroCompra.setFacturacion(null);
        return this;
    }

    public void setRegistroCompras(Set<RegistroCompra> registroCompras) {
        this.registroCompras = registroCompras;
    }

    public EquipoEmpresas getEquipoEmpresas() {
        return equipoEmpresas;
    }

    public Facturacion equipoEmpresas(EquipoEmpresas equipoEmpresas) {
        this.equipoEmpresas = equipoEmpresas;
        return this;
    }

    public void setEquipoEmpresas(EquipoEmpresas equipoEmpresas) {
        this.equipoEmpresas = equipoEmpresas;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Facturacion facturacion = (Facturacion) o;
        if (facturacion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), facturacion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Facturacion{" +
            "id=" + getId() +
            ", titularFactura='" + getTitularFactura() + "'" +
            ", tipoPersona='" + getTipoPersona() + "'" +
            ", periodicidadFacturacion='" + getPeriodicidadFacturacion() + "'" +
            ", maximoMonto=" + getMaximoMonto() +
            "}";
    }
}