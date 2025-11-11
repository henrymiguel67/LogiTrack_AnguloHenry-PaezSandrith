package com.c3.logitrack.model;

public class ReporteResumenDTO {
    private String bodega;
    private int totalProductos;
    private int totalMovimientos;

    // Getters y setters
    public String getBodega() { return bodega; }
    public void setBodega(String bodega) { this.bodega = bodega; }

    public int getTotalProductos() { return totalProductos; }
    public void setTotalProductos(int totalProductos) { this.totalProductos = totalProductos; }

    public int getTotalMovimientos() { return totalMovimientos; }
    public void setTotalMovimientos(int totalMovimientos) { this.totalMovimientos = totalMovimientos; }
}