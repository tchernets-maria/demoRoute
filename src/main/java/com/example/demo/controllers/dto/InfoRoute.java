package com.example.demo.controllers.dto;

import com.example.demo.models.types.Station;
import com.example.demo.models.types.Transport;

public class InfoRoute {
    private Transport transport;
    private String nameTransport;
    private String companyInfoTransport;

    private Station station;
    private String nameStationFrom;
    private String addressStationFrom;
    private String nameStationTo;
    private String addressStationTo;

    private String nameCompany;
    private String emailCompany;
    private String phoneCompany;

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getNameTransport() {
        return nameTransport;
    }

    public void setNameTransport(String nameTransport) {
        this.nameTransport = nameTransport;
    }

    public String getCompanyInfoTransport() {
        return companyInfoTransport;
    }

    public void setCompanyInfoTransport(String companyInfoTransport) {
        this.companyInfoTransport = companyInfoTransport;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getNameStationFrom() {
        return nameStationFrom;
    }

    public void setNameStationFrom(String nameStationFrom) {
        this.nameStationFrom = nameStationFrom;
    }

    public String getAddressStationFrom() {
        return addressStationFrom;
    }

    public void setAddressStationFrom(String addressStationFrom) {
        this.addressStationFrom = addressStationFrom;
    }

    public String getNameStationTo() {
        return nameStationTo;
    }

    public void setNameStationTo(String nameStationTo) {
        this.nameStationTo = nameStationTo;
    }

    public String getAddressStationTo() {
        return addressStationTo;
    }

    public void setAddressStationTo(String addressStationTo) {
        this.addressStationTo = addressStationTo;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getEmailCompany() {
        return emailCompany;
    }

    public void setEmailCompany(String emailCompany) {
        this.emailCompany = emailCompany;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public InfoRoute() {
    }

    public InfoRoute(Transport transport, String nameTransport, String companyInfoTransport, Station station,
                     String nameStationFrom, String addressStationFrom, String nameStationTo, String addressStationTo,
                     String nameCompany, String emailCompany, String phoneCompany) {
        this.transport = transport;
        this.nameTransport = nameTransport;
        this.companyInfoTransport = companyInfoTransport;
        this.station = station;
        this.nameStationFrom = nameStationFrom;
        this.addressStationFrom = addressStationFrom;
        this.nameStationTo = nameStationTo;
        this.addressStationTo = addressStationTo;
        this.nameCompany = nameCompany;
        this.emailCompany = emailCompany;
        this.phoneCompany = phoneCompany;
    }
}
