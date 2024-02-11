package com.example.demo.models;

import com.example.demo.models.types.Station;
import com.example.demo.models.types.Transport;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idTransport, idStationFrom, idStationTo, idCompany;

    private Transport transport;

    private Station stationFrom;

    private Station stationTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdStationFrom() {
        return idStationFrom;
    }

    public void setIdStationFrom(Long idStationFrom) {
        this.idStationFrom = idStationFrom;
    }

    public Long getIdStationTo() {
        return idStationTo;
    }

    public void setIdStationTo(Long idStationTo) {
        this.idStationTo = idStationTo;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public Long getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(Long idTransport) {
        this.idTransport = idTransport;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Station getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(Station stationFrom) {
        this.stationFrom = stationFrom;
    }

    public Station getStationTo() {
        return stationTo;
    }

    public void setStationTo(Station stationTo) {
        this.stationTo = stationTo;
    }

    public Route() {
    }

    public Route(Long idTransport, Long idStationFrom, Long idStationTo, Long idCompany, Transport transport, Station stationFrom, Station stationTo) {
        this.idTransport = idTransport;
        this.idStationFrom = idStationFrom;
        this.idStationTo = idStationTo;
        this.idCompany = idCompany;
        this.transport = transport;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
    }
}
