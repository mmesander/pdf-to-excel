package nl.mesander.pdf_to_excel.dtos.output;

// Imports
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {
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
}