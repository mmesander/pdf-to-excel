package nl.mesander.pdf_to_excel.dtos;

// Imports
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class invoiceInputDto {
    private String invoiceNumber;
    private String invoiceDate;
    private String orderNumber;
    private String orderDate;

    private String customerName;
    private String customerAddress;
    private String customerZipcode;
    private String customerCity;
    private String customerCountry;
}
