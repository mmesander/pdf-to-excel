package nl.mesander.pdf_to_excel.services;

// Imports
import nl.mesander.pdf_to_excel.dtos.input.InvoiceInputDto;
import nl.mesander.pdf_to_excel.dtos.output.InvoiceDto;
import nl.mesander.pdf_to_excel.exceptions.InvalidInputException;
import nl.mesander.pdf_to_excel.exceptions.RecordNotFoundException;
import nl.mesander.pdf_to_excel.models.Invoice;
import nl.mesander.pdf_to_excel.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static nl.mesander.pdf_to_excel.helpers.CopyProperties.copyProperties;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // Transfer Methods
    public static Invoice dtoToInvoice(InvoiceInputDto inputDto) {
        Invoice invoice = new Invoice();

        copyProperties(inputDto, invoice);

        return invoice;
    }

    public static InvoiceDto invoiceToDto(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();

        copyProperties(invoice, invoiceDto);

        return invoiceDto;
    }

    // CRUD Methods
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceDto> invoiceDtos = new ArrayList<>();

        for (Invoice invoice : invoices) {
            InvoiceDto invoiceDto = invoiceToDto(invoice);
            invoiceDtos.add(invoiceDto);
        }

        if (invoiceDtos.isEmpty()) {
            throw new RecordNotFoundException("No invoices found");
        } else {
            return invoiceDtos;
        }
    }

    public InvoiceDto getInvoice(String invoiceNumber) {
        String invoiceNumberUppercase = invoiceNumber.toUpperCase();

        Invoice invoice = invoiceRepository.findById(invoiceNumberUppercase)
                .orElseThrow(() -> new RecordNotFoundException("Invoice with number: " + invoiceNumberUppercase + " not found"));

        return invoiceToDto(invoice);
    }

//    public List<InvoiceDto> getInvoicesByFilter() {}

    public InvoiceDto createInvoice(InvoiceInputDto inputDto) {
        Invoice invoice = dtoToInvoice(inputDto);

        boolean invoiceNumberExists = invoiceRepository.existsById(inputDto.getInvoiceNumber());

        if (invoiceNumberExists) {
            throw new InvalidInputException("Invoice with number: " + inputDto.getInvoiceNumber() + " already exists");
        } else {
            invoiceRepository.save(invoice);
            return invoiceToDto(invoice);
        }
    }

    public String deleteInvoice(String invoiceNumber) {
        String invoiceNumberUppercase = invoiceNumber.toUpperCase();

        Invoice invoice = invoiceRepository.findById(invoiceNumberUppercase)
                .orElseThrow(() -> new RecordNotFoundException("Invoice with number: " + invoiceNumberUppercase + " not found"));

        invoiceRepository.delete(invoice);

        return "Invoice with number: " + invoiceNumberUppercase + " is deleted";
    }
}
