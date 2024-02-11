package com.example.demo.controllers.dto;

import com.example.demo.models.types.Transport;

public class MainInfoRoute {
    private Long id;
    private String nameStationFrom;
    private String nameStationTo;
    private Transport transport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStationFrom() {
        return nameStationFrom;
    }

    public void setNameStationFrom(String nameStationFrom) {
        this.nameStationFrom = nameStationFrom;
    }

    public String getNameStationTo() {
        return nameStationTo;
    }

    public void setNameStationTo(String nameStationTo) {
        this.nameStationTo = nameStationTo;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public MainInfoRoute(Long id, String nameStationFrom, String nameStationTo, Transport transport) {
        this.id = id;
        this.nameStationFrom = nameStationFrom;
        this.nameStationTo = nameStationTo;
        this.transport = transport;
    }
}
