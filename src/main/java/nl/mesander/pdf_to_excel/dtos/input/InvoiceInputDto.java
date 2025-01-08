package nl.mesander.pdf_to_excel.dtos.input;

import lombok.Getter;

// Imports
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
public class InvoiceInputDto {
    private String invoiceNumber;
    private String invoiceDate;
    private String orderNumber;
    private String orderDate;

    private String customerName;
    private String customerAddress;
    private String customerZipcode;
    private String customerCity;
    private String customerCountry;

    private String product;
    private Double price;
    private Integer quantity;
    private Double totalExcludingVat;
    private Double totalVat;
    private Double totalIncludingVat;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerZipcode() {
        return customerZipcode;
    }

    public void setCustomerZipcode(String customerZipcode) {
        this.customerZipcode = customerZipcode;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalExcludingVat() {
        return totalExcludingVat;
    }

    public void setTotalExcludingVat(Double totalExcludingVat) {
        this.totalExcludingVat = totalExcludingVat;
    }

    public Double getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(Double totalVat) {
        this.totalVat = totalVat;
    }

    public Double getTotalIncludingVat() {
        return totalIncludingVat;
    }

    public void setTotalIncludingVat(Double totalIncludingVat) {
        this.totalIncludingVat = totalIncludingVat;
    }
}
