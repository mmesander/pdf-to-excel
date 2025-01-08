package nl.mesander.pdf_to_excel.models;

// Imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {
    // Variables
    @Id
    @Column(nullable = false, unique = true)
    private String invoiceNumber;

    @Column(nullable = false)
    private String invoiceDate;

    @Column(nullable = false)
    private String orderNumber;

    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerAddress;

    @Column(nullable = false)
    private String customerZipcode;

    @Column(nullable = false)
    private String customerCity;

    @Column(nullable = false)
    private String customerCountry;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double totalExcludingVat;

    @Column(nullable = false)
    private Double totalVat;

    @Column(nullable = false)
    private Double totalIncludingVat;
}
