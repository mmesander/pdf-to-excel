package nl.mesander.pdf_to_excel.repositories;

public interface InvoiceRepository {
    boolean existsByInvoiceNumberIgnoreCase(String invoiceNumber);
}
