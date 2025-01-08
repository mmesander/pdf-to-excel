package nl.mesander.pdf_to_excel.repositories;

// Imports
import nl.mesander.pdf_to_excel.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    boolean existsByInvoiceNumberIgnoreCase(String invoiceNumber);
}
